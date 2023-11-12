package fittibackendapp.domain.exercise.graphql.schema

import fittibackendapp.domain.exercise.service.ExerciseExerciseRecordService
import fittibackendapp.dto.ExerciseExerciseRecordDto
import fittibackendapp.dto.ExerciseSessionRecordDto
import org.springframework.graphql.data.method.annotation.BatchMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExerciseExerciseRecordSchemaMapper(
    private val exerciseExerciseRecordService: ExerciseExerciseRecordService,
) {
    @BatchMapping(field = "exerciseExerciseRecords", typeName = "ExerciseSessionRecord")
    fun mapExerciseExerciseRecordsByExerciseSessionRecords(exerciseSessionRecords: List<ExerciseSessionRecordDto>): Map<ExerciseSessionRecordDto, List<ExerciseExerciseRecordDto>> {
        val exerciseSessionRecordIds = exerciseSessionRecords.map { it.id }

        return exerciseExerciseRecordService
            .listByExerciseSessionRecordIds(exerciseSessionRecordIds)
            .groupBy { it.exerciseSessionRecord }
    }
}
