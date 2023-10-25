package fittibackendapp.domain.exercise.repository

import fittibackendapp.domain.exercise.entity.ExerciseKind
import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseKindRepository: JpaRepository<ExerciseKind, Long>
