package fittibackendapp.domain.exercise.service

import fittibackendapp.domain.auth.repository.UserRepository
import fittibackendapp.domain.exercise.entity.ExerciseRecord1
import fittibackendapp.domain.exercise.repository.ExerciseRecord1Repository
import fittibackendapp.dto.ExerciseRecord1Dto
import fittibackendapp.dto.mapstruct.ExerciseRecord1MapStruct
import fittibackendapp.exception.NotFoundExerciseRecord1Exception
import fittibackendapp.exception.NotFoundUserException
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class ExerciseRecord1Service(
    private val exerciseRecord1Repository: ExerciseRecord1Repository,
    private val userRepository: UserRepository,
    private val exerciseRecord1MapStruct: ExerciseRecord1MapStruct,
) {

    fun listByDate(
        userId: Long,
        date: LocalDate,
    ): List<ExerciseRecord1Dto> {
        val user = userRepository.findByIdOrNull(userId) ?: throw NotFoundUserException()

        val exerciseRecord1s = exerciseRecord1Repository.findAllByUserAndStartTimeBetween(
            user = user,
            startTime = date.atStartOfDay(),
            endTime = date.atTime(LocalDateTime.MAX.toLocalTime()),
        ) // todo QueryDsl

        return exerciseRecord1MapStruct.toDtos(exerciseRecord1s)
    }

    fun findById(
        id: Long,
        userId: Long,
    ): ExerciseRecord1Dto {
        val user = userRepository.findByIdOrNull(userId) ?: throw NotFoundUserException()

        val exerciseRecord1 = exerciseRecord1Repository.findByUserAndId(
            user = user,
            id = id,
        ) ?: throw NotFoundExerciseRecord1Exception()

        return exerciseRecord1MapStruct.toDto(exerciseRecord1)
    }

    @Transactional
    fun create(
        userId: Long,
        memo: String,
        startTime: LocalDateTime,
        endTime: LocalDateTime,
    ): ExerciseRecord1Dto {
        val user = userRepository.findByIdOrNull(userId) ?: throw NotFoundUserException()

        val exerciseRecord1 = ExerciseRecord1(
            user = user,
            memo = memo,
            startTime = startTime,
            endTime = endTime,
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
    ): ExerciseRecord1Dto {
        val user = userRepository.findByIdOrNull(userId) ?: throw NotFoundUserException()

        val exerciseRecord1 = exerciseRecord1Repository.findByIdOrNull(exerciseRecord1Id)
            ?: throw NotFoundExerciseRecord1Exception()

        val updatedExerciseRecord1 = exerciseRecord1.apply {
            this.user = user
            this.memo = memo
            this.startTime = startTime
            this.endTime = endTime
        }.run {
            exerciseRecord1Repository.save(this)
        }

        return exerciseRecord1MapStruct.toDto(updatedExerciseRecord1)
    }
}

