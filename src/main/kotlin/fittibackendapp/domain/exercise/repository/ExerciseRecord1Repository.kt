package fittibackendapp.domain.exercise.repository

import fittibackendapp.domain.exercise.entity.ExerciseRecord1
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface ExerciseRecord1Repository: JpaRepository<ExerciseRecord1, Long> {

    fun findAllByStartTimeBetween(
        startTime: LocalDateTime,
        endTime: LocalDateTime
    ): List<ExerciseRecord1>
}
