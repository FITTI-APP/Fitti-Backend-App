package fittibackendapp.domain.exercise.graphql.mutation.input

data class ExerciseExerciseRecordInput(
    val exerciseExerciseRecordId: Long?,
    val exerciseId: Long,
    val order: Int,
    val memo: String,
    val exerciseSetRecordInputs: List<ExerciseSetRecordInput>
)
