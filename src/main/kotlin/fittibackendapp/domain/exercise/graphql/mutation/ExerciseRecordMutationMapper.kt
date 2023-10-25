package fittibackendapp.domain.exercise.graphql.mutation

import fittibackendapp.domain.exercise.facade.ExerciseRecordMutationFacade
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseRecordMutationMapper(
    private val exerciseRecordMutationFacade: ExerciseRecordMutationFacade
)
