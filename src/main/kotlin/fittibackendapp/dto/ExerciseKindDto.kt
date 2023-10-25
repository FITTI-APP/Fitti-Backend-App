package fittibackendapp.dto

import java.io.Serializable

/**
 * DTO for {@link fittibackendapp.domain.exercise.entity.ExerciseKind}
 */
data class ExerciseKindDto(

    val name: String,

    val type: String,

    val id: Long
): Serializable
