package fittibackendapp.domain.exercise.service

import fittibackendapp.domain.exercise.entity.ExerciseRecord2
import fittibackendapp.domain.exercise.repository.ExerciseRecord1Repository
import fittibackendapp.domain.exercise.repository.ExerciseRecord2Repository
import fittibackendapp.domain.exercise.repository.ExerciseRepository
import fittibackendapp.dto.ExerciseRecord2Dto
import fittibackendapp.dto.mapstruct.ExerciseRecord2MapStruct
import fittibackendapp.exception.NotFoundExerciseException
import fittibackendapp.exception.NotFoundExerciseRecord1Exception
import fittibackendapp.exception.NotFoundExerciseRecord2Exception
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ExerciseRecord2Service(
    private val exerciseRecord2Repository: ExerciseRecord2Repository,
    private val exerciseRepository: ExerciseRepository,
    private val exerciseRecord1Repository: ExerciseRecord1Repository,
    private val exerciseRecord2MapStruct: ExerciseRecord2MapStruct
) {

    @Transactional
    fun create(
        exerciseRecord1Id: Long,
        exerciseId: Long,
        order: Int,
        memo: String,
    ): ExerciseRecord2Dto {
        val exerciseRecord1 = exerciseRecord1Repository.findByIdOrNull(exerciseRecord1Id)
            ?: throw NotFoundExerciseRecord1Exception()

        val exercise = exerciseRepository.findByIdOrNull(exerciseId)
            ?: throw NotFoundExerciseException()

        val exerciseRecord2 = ExerciseRecord2(
            exerciseRecord1 = exerciseRecord1,
            exercise = exercise,
            order = order,
            memo = memo,
        ).run {
            exerciseRecord2Repository.save(this)
        }

        return exerciseRecord2MapStruct.toDto(exerciseRecord2)
    }

    @Transactional
    fun update(
        exerciseRecord1Id: Long,
        exerciseRecord2Id: Long,
        exerciseId: Long,
        order: Int,
        memo: String,
    ): ExerciseRecord2Dto {
        val exerciseRecord1 = exerciseRecord1Repository.findByIdOrNull(exerciseRecord1Id)
            ?: throw NotFoundExerciseRecord1Exception()

        val exercise = exerciseRepository.findByIdOrNull(exerciseId)
            ?: throw NotFoundExerciseException()

        val exerciseRecord2 = exerciseRecord2Repository.findByIdOrNull(exerciseRecord2Id)
            ?: throw NotFoundExerciseRecord2Exception()

        val updatedExerciseRecord2 = exerciseRecord2.apply {
            this.exerciseRecord1 = exerciseRecord1
            this.exercise = exercise
            this.order = order
            this.memo = memo
        }.run {
            exerciseRecord2Repository.save(this)
        }

        return exerciseRecord2MapStruct.toDto(updatedExerciseRecord2)
    }

    fun listExerciseRecord2sByExerciseRecord1Id(
        exerciseRecord1Id: Long?
    ): List<ExerciseRecord2Dto> {
        val exerciseRecord2s = exerciseRecord2Repository.findAllByExerciseRecord1Id(exerciseRecord1Id)
        return exerciseRecord2MapStruct.toDtos(exerciseRecord2s)
    }

    fun listByExerciseRecord1Ids(
        exerciseRecord1Ids: List<Long>
    ): List<ExerciseRecord2Dto> {
        val exerciseRecord2s = exerciseRecord2Repository.findAllByExerciseRecord1IdIn(exerciseRecord1Ids)
        return exerciseRecord2MapStruct.toDtos(exerciseRecord2s)
    }

    @Transactional
    fun deleteAll(exerciseRecord2Ids: List<Long>) {
        val exerciseRecord2s = exerciseRecord2Repository.findAllById(exerciseRecord2Ids)
        exerciseRecord2Repository.deleteAll(exerciseRecord2s)
    }
}
