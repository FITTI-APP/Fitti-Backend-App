package fittibackendapp.domain.exercise.repository

import fittibackendapp.domain.exercise.entity.ExerciseRecord3
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseRecord3Repository: JpaRepository<ExerciseRecord3, Long> {
    fun findAllByExerciseRecord2IdIn(exerciseRecord2Ids: List<Long>): List<ExerciseRecord3>
    fun findAllByExerciseRecord2Id(exerciseRecord2Id: Long?): List<ExerciseRecord3>
}
