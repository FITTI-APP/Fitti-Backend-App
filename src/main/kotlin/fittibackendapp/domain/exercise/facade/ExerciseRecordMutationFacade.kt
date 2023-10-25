package fittibackendapp.domain.exercise.facade

import fittibackendapp.domain.exercise.service.ExerciseRecordService
import org.springframework.stereotype.Service

@Service
class ExerciseRecordMutationFacade(
    private val exerciseRecordService: ExerciseRecordService
)
