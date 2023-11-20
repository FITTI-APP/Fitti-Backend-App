package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class NotFoundExerciseExerciseRecordException: ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "NOT_FOUND_EXERCISE_EXERCISE_RECORD",
    reasonMessage = "존재하지 않는 운동 종목 기록 입니다.",
)
