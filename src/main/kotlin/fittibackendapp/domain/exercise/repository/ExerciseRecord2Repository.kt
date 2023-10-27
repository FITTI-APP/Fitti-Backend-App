package fittibackendapp.domain.exercise.repository

import fittibackendapp.domain.exercise.entity.ExerciseRecord2
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseRecord2Repository: JpaRepository<ExerciseRecord2, Long> {

    fun findAllByExerciseRecord1Id(exerciseRecord1Id: Long?): List<ExerciseRecord2>
}
