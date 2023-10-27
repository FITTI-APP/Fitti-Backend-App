package fittibackendapp.domain.exercise.graphql.mutation.input

import java.time.Duration

data class ExerciseRecord3Input(
    val exerciseRecord3Id: Long?,
    val memo: String,
    val order: Int,
    val weight: Double,
    val reps: Int,
    val distance: Double,
    val totalTime: Duration
)
