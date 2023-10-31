package fittibackendapp.domain.exercise.graphql.mutation.input

import java.time.LocalDateTime

data class ExerciseRecord1Input(
    val exerciseRecord1Id: Long?,
    val memo: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val exerciseRecord2Inputs: List<ExerciseRecord2Input>
)


