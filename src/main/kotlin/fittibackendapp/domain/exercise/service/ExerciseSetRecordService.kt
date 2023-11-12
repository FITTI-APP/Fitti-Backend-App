package fittibackendapp.domain.exercise.service

import fittibackendapp.domain.exercise.entity.ExerciseSetRecord
import fittibackendapp.domain.exercise.repository.ExerciseExerciseRecordRepository
import fittibackendapp.domain.exercise.repository.ExerciseSetRecordRepository
import fittibackendapp.dto.ExerciseSetRecordDto
import fittibackendapp.dto.mapstruct.ExerciseSetRecordMapStruct
import fittibackendapp.exception.NotFoundExerciseExerciseRecordException
import fittibackendapp.exception.NotFoundExerciseSetRecordException
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class ExerciseSetRecordService(
    private val exerciseSetRecordRepository: ExerciseSetRecordRepository,
    private val exerciseExerciseRecordRepository: ExerciseExerciseRecordRepository,
    private val exerciseSetRecordMapStruct: ExerciseSetRecordMapStruct,
) {
    @Transactional
    fun create(
        exerciseExerciseRecordId: Long,
        memo: String,
        order: Int,
        weight: Double,
        reps: Int,
        distance: Double,
        totalTime: Duration
    ): ExerciseSetRecordDto {
        val exerciseExerciseRecord = exerciseExerciseRecordRepository.findByIdOrNull(exerciseExerciseRecordId)
            ?: throw NotFoundExerciseExerciseRecordException()

        val exerciseSetRecord = ExerciseSetRecord(
            exerciseExerciseRecord = exerciseExerciseRecord,
            memo = memo,
            order = order,
            weight = weight,
            reps = reps,
            distance = distance,
            totalTime = totalTime,
        ).run {
            exerciseSetRecordRepository.save(this)
        }

        return exerciseSetRecordMapStruct.toDto(exerciseSetRecord)
    }

    @Transactional
    fun update(
        exerciseExerciseRecordId: Long,
        exerciseSetRecordId: Long,
        memo: String,
        order: Int,
        weight: Double,
        reps: Int,
        distance: Double,
        totalTime: Duration
    ): ExerciseSetRecordDto {
        val exerciseExerciseRecord = exerciseExerciseRecordRepository.findByIdOrNull(exerciseExerciseRecordId)
            ?: throw NotFoundExerciseExerciseRecordException()

        val exerciseSetRecord = exerciseSetRecordRepository.findByIdOrNull(exerciseSetRecordId)
            ?: throw NotFoundExerciseSetRecordException()

        val updatedExerciseSetRecord = exerciseSetRecord.apply {
            this.exerciseExerciseRecord = exerciseExerciseRecord
            this.memo = memo
            this.order = order
            this.weight = weight
            this.reps = reps
            this.distance = distance
            this.totalTime = totalTime
        }.run {
            exerciseSetRecordRepository.save(this)
        }

        return exerciseSetRecordMapStruct.toDto(updatedExerciseSetRecord)
    }

    fun listExerciseSetRecordsByExerciseExerciseRecordId(
        exerciseExerciseRecordId: Long?
    ): List<ExerciseSetRecordDto> {
        val exerciseSetRecords = exerciseSetRecordRepository.findAllByExerciseExerciseRecordId(exerciseExerciseRecordId)
        return exerciseSetRecordMapStruct.toDtos(exerciseSetRecords)
    }

    fun listByExerciseExerciseRecordIds(
        exerciseExerciseRecordIds: List<Long>
    ): List<ExerciseSetRecordDto> {
        val exerciseSetRecords =
            exerciseSetRecordRepository.findAllByExerciseExerciseRecordIdIn(exerciseExerciseRecordIds)
        return exerciseSetRecordMapStruct.toDtos(exerciseSetRecords)
    }

    @Transactional
    fun deleteAll(
        ids: List<Long>
    ) {
        exerciseSetRecordRepository
            .findAllById(ids)
            .run { exerciseSetRecordRepository.deleteAll(this) }
    }
}
