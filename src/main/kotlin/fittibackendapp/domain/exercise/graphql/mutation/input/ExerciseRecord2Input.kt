package fittibackendapp.domain.exercise.graphql.mutation.input

data class ExerciseRecord2Input(
    val exerciseRecord2Id: Long?,
    val exerciseId: Long,
    val order: Int,
    val memo: String,
    val exerciseRecord3Inputs: List<ExerciseRecord3Input>
)
