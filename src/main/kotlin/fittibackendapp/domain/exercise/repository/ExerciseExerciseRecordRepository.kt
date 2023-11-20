package fittibackendapp.domain.exercise.repository

import fittibackendapp.domain.exercise.entity.ExerciseExerciseRecord
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseExerciseRecordRepository: JpaRepository<ExerciseExerciseRecord, Long> {
    fun findAllByExerciseSessionRecordIdIn(exerciseSessionRecordIds: List<Long>): List<ExerciseExerciseRecord>
    fun findAllByExerciseSessionRecordId(exerciseSessionRecordId: Long?): List<ExerciseExerciseRecord>
}
