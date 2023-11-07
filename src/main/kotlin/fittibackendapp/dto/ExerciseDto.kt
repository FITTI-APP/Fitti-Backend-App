package fittibackendapp.dto

import java.io.Serializable

/**
 * DTO for {@link fittibackendapp.domain.exercise.entity.Exercise}
 */
data class ExerciseDto(
    val name: String,
    val kind: ExerciseKindDto,
    val id: Long
): Serializable
