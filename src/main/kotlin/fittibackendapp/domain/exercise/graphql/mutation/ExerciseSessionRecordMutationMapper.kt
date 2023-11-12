package fittibackendapp.domain.exercise.graphql.mutation

import fittibackendapp.domain.exercise.facade.ExerciseRecordMutationFacade
import fittibackendapp.domain.exercise.graphql.mutation.input.ExerciseSessionRecordInput
import fittibackendapp.dto.ExerciseSessionRecordDto
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseSessionRecordMutationMapper(
    private val exerciseRecordMutationFacade: ExerciseRecordMutationFacade,
) {
    @MutationMapping
    fun putExerciseSessionRecord(
        @Argument
        exerciseSessionRecordInput: ExerciseSessionRecordInput
    ): ExerciseSessionRecordDto {
        val userId = 1L

        val exerciseExerciseRecordInputs = exerciseSessionRecordInput.exerciseExerciseRecordInputs
        exerciseRecordMutationFacade.deleteExerciseExerciseRecords(
            exerciseSessionRecordId = exerciseSessionRecordInput.exerciseSessionRecordId,
            exerciseExerciseRecordInputs = exerciseExerciseRecordInputs,
        )
        return exerciseRecordMutationFacade.createOrUpdateExerciseSessionRecord(
            userId = userId,
            exerciseSessionRecordInput = exerciseSessionRecordInput,
        )
    }
}
