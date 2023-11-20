package fittibackendapp.domain.exercise.graphql.mutation.input

import java.time.Duration

data class ExerciseSetRecordInput(
    val exerciseSetRecordId: Long?,
    val memo: String,
    val order: Int,
    val weight: Double,
    val reps: Int,
    val distance: Double,
    val totalTime: Duration
)
