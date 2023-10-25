package fittibackendapp.dto

import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link fittibackendapp.domain.exercise.entity.ExerciseRecord1}
 */
data class ExerciseRecord1Dto(
    val user: UserDto,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val memo: String,
    val id: Long
): Serializable
