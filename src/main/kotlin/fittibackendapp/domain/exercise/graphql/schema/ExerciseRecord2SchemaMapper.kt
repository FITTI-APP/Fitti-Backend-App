package fittibackendapp.domain.exercise.graphql.schema

import fittibackendapp.domain.exercise.service.ExerciseRecord2Service
import fittibackendapp.dto.ExerciseRecord1Dto
import fittibackendapp.dto.ExerciseRecord2Dto
import org.springframework.graphql.data.method.annotation.BatchMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseRecord2SchemaMapper(
    private val exerciseRecord2Service: ExerciseRecord2Service,
) {
    @BatchMapping(field = "exerciseRecord2s", typeName = "ExerciseRecord1")
    fun mapExerciseRecord2sByExerciseRecord1s(exerciseRecord1s: List<ExerciseRecord1Dto>): Map<ExerciseRecord1Dto, List<ExerciseRecord2Dto>> {
        val exerciseRecord1Ids = exerciseRecord1s.map { it.id }

        return exerciseRecord2Service
            .listByExerciseRecord1Ids(exerciseRecord1Ids)
            .groupBy { it.exerciseRecord1 }
    }
}
