package fittibackendapp.domain.exercise.graphql.query

import fittibackendapp.domain.exercise.service.ExerciseSessionRecordService
import fittibackendapp.dto.ExerciseSessionRecordDto
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class ExerciseSessionRecordQueryMapper(
    private val exerciseSessionRecordService: ExerciseSessionRecordService,
) {
    @QueryMapping
    fun exerciseSessionRecordsByDate(
        @Argument
        date: LocalDate,
    ): List<ExerciseSessionRecordDto> {
        val userId = 1L
        return exerciseSessionRecordService.listByDate(
            userId = userId,
            date = date,
        )
    }

    @QueryMapping
    fun exerciseSessionRecordById(
        @Argument
        id: Long,
    ): ExerciseSessionRecordDto {
        val userId = 1L

        return exerciseSessionRecordService.findById(
            id = id,
            userId = userId,
        )
    }
}
