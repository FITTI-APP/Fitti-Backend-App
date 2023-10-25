package fittibackendapp.dto

import java.io.Serializable

/**
 * DTO for {@link fittibackendapp.domain.exercise.entity.ExerciseRecord2}
 */
data class ExerciseRecord2Dto(
    val exerciseRecord1: ExerciseRecord1Dto,
    val exercise: ExerciseDto,
    val order: Int,
    val memo: String,
    val id: Long
): Serializable
