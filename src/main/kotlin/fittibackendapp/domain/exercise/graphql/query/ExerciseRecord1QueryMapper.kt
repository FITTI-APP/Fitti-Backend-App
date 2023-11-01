package fittibackendapp.domain.exercise.graphql.query

import fittibackendapp.domain.exercise.service.ExerciseRecord1Service
import fittibackendapp.dto.ExerciseRecord1Dto
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class ExerciseRecord1QueryMapper(
    private val exerciseRecord1Service: ExerciseRecord1Service,
) {
    @QueryMapping
    fun exerciseRecord1sByDate(
        @Argument
        date: LocalDate,
    ): List<ExerciseRecord1Dto> {
        val userId = 1L
        return exerciseRecord1Service.listByDate(
            userId = userId,
            date = date,
        )
    }

    @QueryMapping
    fun exerciseRecord1ById(
        @Argument
        id: Long,
    ): ExerciseRecord1Dto {
        val userId = 1L

        return exerciseRecord1Service.findById(
            id = id,
            userId = userId,
        )
    }
}