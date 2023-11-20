package fittibackendapp.dto

import java.io.Serializable

/**
 * DTO for {@link fittibackendapp.domain.exercise.entity.ExerciseRecord2}
 */
data class ExerciseExerciseRecordDto(
    val exerciseSessionRecord: ExerciseSessionRecordDto,
    val exercise: ExerciseDto,
    val order: Int,
    val memo: String,
    val id: Long
): Serializable
