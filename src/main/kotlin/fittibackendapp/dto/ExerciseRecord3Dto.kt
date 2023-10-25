package fittibackendapp.dto

import java.io.Serializable
import java.time.LocalTime

/**
 * DTO for {@link fittibackendapp.domain.exercise.entity.ExerciseRecord3}
 */
data class ExerciseRecord3Dto(
    val exerciseRecord2: ExerciseRecord2Dto,
    val order: Int,
    val weight: Double,
    val reps: Int,
    val totalTime: LocalTime,
    val memo: String,
    val distance: Double,
    val id: Long
): Serializable
