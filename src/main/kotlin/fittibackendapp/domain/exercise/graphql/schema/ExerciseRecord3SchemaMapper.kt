package fittibackendapp.domain.exercise.graphql.schema

import fittibackendapp.domain.exercise.service.ExerciseRecord3Service
import fittibackendapp.dto.ExerciseRecord2Dto
import fittibackendapp.dto.ExerciseRecord3Dto
import org.springframework.graphql.data.method.annotation.BatchMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseRecord3SchemaMapper(
    private val exerciseRecord3Service: ExerciseRecord3Service,
) {
    @BatchMapping(field = "exerciseRecord3s", typeName = "ExerciseRecord2")
    fun mapExerciseRecord3sByExerciseRecord2s(exerciseRecord2s: List<ExerciseRecord2Dto>): Map<ExerciseRecord2Dto, List<ExerciseRecord3Dto>> {
        val exerciseRecord2Ids = exerciseRecord2s.map { it.id }

        return exerciseRecord3Service
            .listByExerciseRecord2Ids(exerciseRecord2Ids)
            .groupBy { it.exerciseRecord2 }
    }
}
