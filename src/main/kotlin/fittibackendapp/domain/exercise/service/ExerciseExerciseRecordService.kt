package fittibackendapp.domain.exercise.service

import fittibackendapp.domain.exercise.entity.ExerciseExerciseRecord
import fittibackendapp.domain.exercise.repository.ExerciseExerciseRecordRepository
import fittibackendapp.domain.exercise.repository.ExerciseRepository
import fittibackendapp.domain.exercise.repository.ExerciseSessionRecordRepository
import fittibackendapp.dto.ExerciseExerciseRecordDto
import fittibackendapp.dto.mapstruct.ExerciseExerciseRecordMapStruct
import fittibackendapp.exception.NotFoundExerciseException
import fittibackendapp.exception.NotFoundExerciseExerciseRecordException
import fittibackendapp.exception.NotFoundExerciseSessionRecordException
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ExerciseExerciseRecordService(
    private val exerciseExerciseRecordRepository: ExerciseExerciseRecordRepository,
    private val exerciseRepository: ExerciseRepository,
    private val exerciseSessionRecordRepository: ExerciseSessionRecordRepository,
    private val exerciseExerciseRecordMapStruct: ExerciseExerciseRecordMapStruct
) {

    @Transactional
    fun create(
        exerciseSessionRecordId: Long,
        exerciseId: Long,
        order: Int,
        memo: String,
    ): ExerciseExerciseRecordDto {
        val exerciseSessionRecord = exerciseSessionRecordRepository.findByIdOrNull(exerciseSessionRecordId)
            ?: throw NotFoundExerciseSessionRecordException()

        val exercise = exerciseRepository.findByIdOrNull(exerciseId)
            ?: throw NotFoundExerciseException()

        val exerciseExerciseRecord = ExerciseExerciseRecord(
            exerciseSessionRecord = exerciseSessionRecord,
            exercise = exercise,
            order = order,
            memo = memo,
        ).run {
            exerciseExerciseRecordRepository.save(this)
        }

        return exerciseExerciseRecordMapStruct.toDto(exerciseExerciseRecord)
    }

    @Transactional
    fun update(
        exerciseSessionRecordId: Long,
        exerciseExerciseRecordId: Long,
        exerciseId: Long,
        order: Int,
        memo: String,
    ): ExerciseExerciseRecordDto {
        val exerciseSessionRecord = exerciseSessionRecordRepository.findByIdOrNull(exerciseSessionRecordId)
            ?: throw NotFoundExerciseSessionRecordException()

        val exercise = exerciseRepository.findByIdOrNull(exerciseId)
            ?: throw NotFoundExerciseException()

        val exerciseExerciseRecord = exerciseExerciseRecordRepository.findByIdOrNull(exerciseExerciseRecordId)
            ?: throw NotFoundExerciseExerciseRecordException()

        val updatedExerciseExerciseRecord = exerciseExerciseRecord.apply {
            this.exerciseSessionRecord = exerciseSessionRecord
            this.exercise = exercise
            this.order = order
            this.memo = memo
        }.run {
            exerciseExerciseRecordRepository.save(this)
        }

        return exerciseExerciseRecordMapStruct.toDto(updatedExerciseExerciseRecord)
    }

    fun listExerciseExerciseRecordsByExerciseSessionRecordId(
        exerciseSessionRecordId: Long?
    ): List<ExerciseExerciseRecordDto> {
        val exerciseExerciseRecords =
            exerciseExerciseRecordRepository.findAllByExerciseSessionRecordId(exerciseSessionRecordId)
        return exerciseExerciseRecordMapStruct.toDtos(exerciseExerciseRecords)
    }

    fun listByExerciseSessionRecordIds(
        exerciseSessionRecordIds: List<Long>
    ): List<ExerciseExerciseRecordDto> {
        val exerciseExerciseRecords =
            exerciseExerciseRecordRepository.findAllByExerciseSessionRecordIdIn(exerciseSessionRecordIds)
        return exerciseExerciseRecordMapStruct.toDtos(exerciseExerciseRecords)
    }

    @Transactional
    fun deleteAll(exerciseExerciseRecordIds: List<Long>) {
        val exerciseExerciseRecords = exerciseExerciseRecordRepository.findAllById(exerciseExerciseRecordIds)
        exerciseExerciseRecordRepository.deleteAll(exerciseExerciseRecords)
    }
}
