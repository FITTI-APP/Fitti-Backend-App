package fittibackendapp.domain.exercise.repository

import fittibackendapp.domain.exercise.entity.Exercise
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseRepository: JpaRepository<Exercise, Long> {
    fun findAllByKindId(kindId: Long?): List<Exercise>
}
