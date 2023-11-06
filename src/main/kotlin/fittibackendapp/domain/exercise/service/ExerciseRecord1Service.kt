package fittibackendapp.domain.exercise.service

import fittibackendapp.domain.auth.repository.UserRepository
import fittibackendapp.domain.exercise.entity.ExerciseRecord1
import fittibackendapp.domain.exercise.repository.ExerciseRecord1Repository
import fittibackendapp.domain.exercise.repository.ExerciseSaveTypeRepository
import fittibackendapp.dto.ExerciseRecord1Dto
import fittibackendapp.dto.mapstruct.ExerciseRecord1MapStruct
import fittibackendapp.exception.NotFoundExerciseRecord1Exception
import fittibackendapp.exception.NotFoundExerciseSaveTypeException
import fittibackendapp.exception.NotFoundUserException
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ExerciseRecord1Service(
    private val exerciseRecord1Repository: ExerciseRecord1Repository,
    private val userRepository: UserRepository,
    private val exerciseRecord1MapStruct: ExerciseRecord1MapStruct,
    private val exerciseSaveTypeRepository: ExerciseSaveTypeRepository,
) {

    @Transactional
    fun create(
        userId: Long,
        memo: String,
        startTime: LocalDateTime,
        endTime: LocalDateTime,
        saveTypeId: Long,
    ): ExerciseRecord1Dto {
        val user = userRepository.findByIdOrNull(userId) ?: throw NotFoundUserException()
        val saveType =
            exerciseSaveTypeRepository.findByIdOrNull(saveTypeId) ?: throw NotFoundExerciseSaveTypeException()
        val exerciseRecord1 = ExerciseRecord1(
            user = user,
            memo = memo,
            startTime = startTime,
            endTime = endTime,
            saveType = saveType,
        ).run {
            exerciseRecord1Repository.save(this)
        }

        return exerciseRecord1MapStruct.toDto(exerciseRecord1)
    }

    @Transactional
    fun update(
        userId: Long,
        exerciseRecord1Id: Long,
        memo: String,
        startTime: LocalDateTime,
        endTime: LocalDateTime,
        saveTypeId: Long,
    ): ExerciseRecord1Dto {
        val user = userRepository.findByIdOrNull(userId) ?: throw NotFoundUserException()
        val saveType =
            exerciseSaveTypeRepository.findByIdOrNull(saveTypeId) ?: throw NotFoundExerciseSaveTypeException()
        val exerciseRecord1 = exerciseRecord1Repository.findByIdOrNull(exerciseRecord1Id)
            ?: throw NotFoundExerciseRecord1Exception()

        val updatedExerciseRecord1 = exerciseRecord1.apply {
            this.user = user
            this.memo = memo
            this.startTime = startTime
            this.endTime = endTime
            this.saveType = saveType
        }.run {
            exerciseRecord1Repository.save(this)
        }

        return exerciseRecord1MapStruct.toDto(updatedExerciseRecord1)
    }
}

