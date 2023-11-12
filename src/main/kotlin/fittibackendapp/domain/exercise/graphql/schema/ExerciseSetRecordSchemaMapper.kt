package fittibackendapp.domain.exercise.graphql.schema

import fittibackendapp.domain.exercise.service.ExerciseSetRecordService
import fittibackendapp.dto.ExerciseExerciseRecordDto
import fittibackendapp.dto.ExerciseSetRecordDto
import org.springframework.graphql.data.method.annotation.BatchMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseSetRecordSchemaMapper(
    private val exerciseSetRecordService: ExerciseSetRecordService,
) {
    @BatchMapping(field = "exerciseSetRecords", typeName = "ExerciseExerciseRecord")
    fun mapExerciseSetRecordsByExerciseExerciseRecords(exerciseExerciseRecords: List<ExerciseExerciseRecordDto>): Map<ExerciseExerciseRecordDto, List<ExerciseSetRecordDto>> {
        val exerciseExerciseRecordIds = exerciseExerciseRecords.map { it.id }

        return exerciseSetRecordService
            .listByExerciseExerciseRecordIds(exerciseExerciseRecordIds)
            .groupBy { it.exerciseExerciseRecord }
    }
}
