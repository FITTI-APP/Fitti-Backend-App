package fittibackendapp.dto

import java.io.Serializable
import java.time.Duration

/**
 * DTO for {@link fittibackendapp.domain.exercise.entity.ExerciseRecord3}
 */
data class ExerciseSetRecordDto(
    val exerciseExerciseRecord: ExerciseExerciseRecordDto,
    val order: Int,
    val weight: Double,
    val reps: Int,
    val totalTime: Duration,
    val memo: String,
    val distance: Double,
    val id: Long
): Serializable
