package fittibackendapp.domain.exercise.facade

import fittibackendapp.domain.exercise.graphql.mutation.input.ExerciseRecord1Input
import fittibackendapp.domain.exercise.graphql.mutation.input.ExerciseRecord2Input
import fittibackendapp.domain.exercise.graphql.mutation.input.ExerciseRecord3Input
import fittibackendapp.domain.exercise.service.ExerciseRecord1Service
import fittibackendapp.domain.exercise.service.ExerciseRecord2Service
import fittibackendapp.domain.exercise.service.ExerciseRecord3Service
import fittibackendapp.dto.ExerciseRecord1Dto
import fittibackendapp.dto.ExerciseRecord2Dto
import fittibackendapp.dto.ExerciseRecord3Dto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class ExerciseRecordMutationFacade(
    private val exerciseRecord1Service: ExerciseRecord1Service,
    private val exerciseRecord2Service: ExerciseRecord2Service,
    private val exerciseRecord3Service: ExerciseRecord3Service,
) {

    @Transactional
    fun createOrUpdateExerciseRecord1(
        userId: Long,
        exerciseRecord1Input: ExerciseRecord1Input
    ): ExerciseRecord1Dto {
        if (exerciseRecord1Input.exerciseRecord1Id == null) {
            exerciseRecord1Service.create(
                userId = userId,
                memo = exerciseRecord1Input.memo,
                startTime = exerciseRecord1Input.startTime,
                endTime = exerciseRecord1Input.endTime,
                saveTypeId = exerciseRecord1Input.saveTypeId,
            )
        }
        else {
            exerciseRecord1Service.update(
                userId = userId,
                exerciseRecord1Id = exerciseRecord1Input.exerciseRecord1Id,
                memo = exerciseRecord1Input.memo,
                startTime = exerciseRecord1Input.startTime,
                endTime = exerciseRecord1Input.endTime,
                saveTypeId = exerciseRecord1Input.saveTypeId,
            )
        }.run {
            createOrUpdateExerciseRecord2s(
                userId = userId,
                exerciseRecord1Id = this.id,
                exerciseRecord2Inputs = exerciseRecord1Input.exerciseRecord2Inputs,
            )
            return this
        }
    }

    @Transactional
    fun createOrUpdateExerciseRecord2s(
        userId: Long,
        exerciseRecord1Id: Long,
        exerciseRecord2Inputs: List<ExerciseRecord2Input>
    ): List<ExerciseRecord2Dto> {
        return exerciseRecord2Inputs.map {
            if (it.exerciseRecord2Id == null) {
                exerciseRecord2Service.create(
                    exerciseRecord1Id = exerciseRecord1Id,
                    exerciseId = it.exerciseId,
                    order = it.order,
                    memo = it.memo,
                )
            }
            else {
                exerciseRecord2Service.update(
                    exerciseRecord1Id = exerciseRecord1Id,
                    exerciseRecord2Id = it.exerciseRecord2Id,
                    exerciseId = it.exerciseId,
                    order = it.order,
                    memo = it.memo,
                )
            }.apply {
                createOrUpdateExerciseRecord3s(
                    userId = userId,
                    exerciseRecord2Id = this.id,
                    exerciseRecord3Inputs = it.exerciseRecord3Inputs,
                )
            }
        }
    }

    @Transactional
    fun createOrUpdateExerciseRecord3s(
        userId: Long,
        exerciseRecord2Id: Long,
        exerciseRecord3Inputs: List<ExerciseRecord3Input>
    ): List<ExerciseRecord3Dto> {
        return exerciseRecord3Inputs.map {
            if (it.exerciseRecord3Id == null) {
                exerciseRecord3Service.create(
                    exerciseRecord2Id = exerciseRecord2Id,
                    weight = it.weight,
                    reps = it.reps,
                    order = it.order,
                    memo = it.memo,
                    distance = it.distance,
                    totalTime = it.totalTime,
                )
            }
            else {
                exerciseRecord3Service.update(
                    exerciseRecord2Id = exerciseRecord2Id,
                    exerciseRecord3Id = it.exerciseRecord3Id,
                    weight = it.weight,
                    order = it.order,
                    memo = it.memo,
                    reps = it.reps,
                    distance = it.distance,
                    totalTime = it.totalTime,
                )
            }
        }
    }

    @Transactional
    fun deleteExerciseRecord2s(
        exerciseRecord1Id: Long?,
        exerciseRecord2Inputs: List<ExerciseRecord2Input>
    ) {
        exerciseRecord2Service
            .listExerciseRecord2sByExerciseRecord1Id(exerciseRecord1Id)
            .ifEmpty { null }
            ?.run {
                map { it.id }
                    .filter {
                        it !in exerciseRecord2Inputs
                            .map { inputs -> inputs.exerciseRecord2Id }
                    }
                    .run { exerciseRecord2Service.deleteAll(this) }
            }

        exerciseRecord2Inputs.map {
            deleteExerciseRecord3s(
                exerciseRecord2Id = it.exerciseRecord2Id,
                exerciseRecord3Inputs = it.exerciseRecord3Inputs,
            )
        }
    }

    @Transactional
    fun deleteExerciseRecord3s(
        exerciseRecord2Id: Long?,
        exerciseRecord3Inputs: List<ExerciseRecord3Input>
    ) {
        exerciseRecord3Service
            .listExerciseRecord3sByExerciseRecord2Id(exerciseRecord2Id)
            .ifEmpty { null }
            ?.run {
                map { it.id }
                    .filter {
                        it !in exerciseRecord3Inputs
                            .map { inputs -> inputs.exerciseRecord3Id }
                    }
                    .run { exerciseRecord3Service.deleteAll(this) }
            }
    }
}
