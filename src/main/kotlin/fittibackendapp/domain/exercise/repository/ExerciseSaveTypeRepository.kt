package fittibackendapp.domain.exercise.repository

import fittibackendapp.domain.exercise.entity.ExerciseSaveType
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseSaveTypeRepository: JpaRepository<ExerciseSaveType, Long>
