package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class NotFoundExerciseRecord3Exception : ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "NOT_FOUND_EXERCISE_RECORD_3",
    reasonMessage = "존재하지 않는 운동 기록 세트 입니다.",
)
