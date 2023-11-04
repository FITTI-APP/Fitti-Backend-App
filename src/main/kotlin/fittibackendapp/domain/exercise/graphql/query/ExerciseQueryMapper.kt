package fittibackendapp.domain.exercise.graphql.query

import fittibackendapp.domain.exercise.service.ExerciseService
import fittibackendapp.dto.ExerciseDto
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseQueryMapper(
    private val exerciseService: ExerciseService,
) {
    @QueryMapping
    fun exercisesByKindId(
        @Argument
        kindId: Long
    ): List<ExerciseDto> {
        return exerciseService.listExercisesByKindId(kindId)
    }
}
