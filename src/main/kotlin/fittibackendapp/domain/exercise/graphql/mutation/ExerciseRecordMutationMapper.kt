package fittibackendapp.domain.exercise.graphql.mutation

import fittibackendapp.domain.exercise.facade.ExerciseRecordMutationFacade
import fittibackendapp.domain.exercise.graphql.mutation.input.ExerciseRecord1Input
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseRecordMutationMapper(
    private val exerciseRecordMutationFacade: ExerciseRecordMutationFacade,

    ) {
    @MutationMapping
    fun putExerciseRecord1(exerciseRecord1Input: ExerciseRecord1Input) {
        val userId = 1L

        val exerciseRecord2Inputs = exerciseRecord1Input.exerciseRecord2Inputs
        exerciseRecordMutationFacade.deleteExerciseRecord2s(
            exerciseRecord1Id = exerciseRecord1Input.exerciseRecord1Id,
            exerciseRecord2Inputs = exerciseRecord2Inputs,
        )
        exerciseRecordMutationFacade.createOrUpdateExerciseRecord1(
            userId = userId,
            exerciseRecord1Input = exerciseRecord1Input,
        )
    }
}
