package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class NotFoundExerciseRecord2Exception : ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "NOT_FOUND_EXERCISE_RECORD_2",
    reasonMessage = "존재하지 않는 운동 기록 종목 입니다.",
)
