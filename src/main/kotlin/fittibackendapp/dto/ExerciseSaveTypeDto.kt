package fittibackendapp.dto

import java.io.Serializable

/**
 * DTO for {@link fittibackendapp.domain.exercise.entity.ExerciseSaveType}
 */
data class ExerciseSaveTypeDto(
    val name: String,
    val id: Long
): Serializable
