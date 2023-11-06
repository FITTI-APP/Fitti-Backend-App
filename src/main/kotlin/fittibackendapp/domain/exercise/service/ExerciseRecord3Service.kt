package fittibackendapp.domain.exercise.service

import fittibackendapp.domain.exercise.entity.ExerciseRecord3
import fittibackendapp.domain.exercise.repository.ExerciseRecord2Repository
import fittibackendapp.domain.exercise.repository.ExerciseRecord3Repository
import fittibackendapp.dto.ExerciseRecord3Dto
import fittibackendapp.dto.mapstruct.ExerciseRecord3MapStruct
import fittibackendapp.exception.NotFoundExerciseRecord2Exception
import fittibackendapp.exception.NotFoundExerciseRecord3Exception
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class ExerciseRecord3Service(
    private val exerciseRecord3Repository: ExerciseRecord3Repository,
    private val exerciseRecord2Repository: ExerciseRecord2Repository,
    private val exerciseRecord3MapStruct: ExerciseRecord3MapStruct,
) {
    @Transactional
    fun create(
        exerciseRecord2Id: Long,
        memo: String,
        order: Int,
        weight: Double,
        reps: Int,
        distance: Double,
        totalTime: Duration
    ): ExerciseRecord3Dto {
        val exerciseRecord2 = exerciseRecord2Repository.findByIdOrNull(exerciseRecord2Id)
            ?: throw NotFoundExerciseRecord2Exception()

        val exerciseRecord3 = ExerciseRecord3(
            exerciseRecord2 = exerciseRecord2,
            memo = memo,
            order = order,
            weight = weight,
            reps = reps,
            distance = distance,
            totalTime = totalTime,
        ).run {
            exerciseRecord3Repository.save(this)
        }

        return exerciseRecord3MapStruct.toDto(exerciseRecord3)
    }

    @Transactional
    fun update(
        exerciseRecord2Id: Long,
        exerciseRecord3Id: Long,
        memo: String,
        order: Int,
        weight: Double,
        reps: Int,
        distance: Double,
        totalTime: Duration
    ): ExerciseRecord3Dto {
        val exerciseRecord2 = exerciseRecord2Repository.findByIdOrNull(exerciseRecord2Id)
            ?: throw NotFoundExerciseRecord2Exception()

        val exerciseRecord3 = exerciseRecord3Repository.findByIdOrNull(exerciseRecord3Id)
            ?: throw NotFoundExerciseRecord3Exception()

        val updatedExerciseRecord3 = exerciseRecord3.apply {
            this.exerciseRecord2 = exerciseRecord2
            this.memo = memo
            this.order = order
            this.weight = weight
            this.reps = reps
            this.distance = distance
            this.totalTime = totalTime
        }.run {
            exerciseRecord3Repository.save(this)
        }

        return exerciseRecord3MapStruct.toDto(updatedExerciseRecord3)
    }

    fun listExerciseRecord3sByExerciseRecord2Id(
        exerciseRecord2Id: Long?
    ): List<ExerciseRecord3Dto> {
        val exerciseRecord3s = exerciseRecord3Repository.findAllByExerciseRecord2Id(exerciseRecord2Id)
        return exerciseRecord3MapStruct.toDtos(exerciseRecord3s)
    }

    fun listByExerciseRecord2Ids(
        exerciseRecord2Ids: List<Long>
    ): List<ExerciseRecord3Dto> {
        val exerciseRecord3s = exerciseRecord3Repository.findAllByExerciseRecord2IdIn(exerciseRecord2Ids)
        return exerciseRecord3MapStruct.toDtos(exerciseRecord3s)
    }

    @Transactional
    fun deleteAll(
        ids: List<Long>
    ) {
        exerciseRecord3Repository
            .findAllById(ids)
            .run { exerciseRecord3Repository.deleteAll(this) }
    }
}
