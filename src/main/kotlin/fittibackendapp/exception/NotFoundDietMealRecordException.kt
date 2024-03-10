package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class NotFoundDietMealRecordException: ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "NOT_FOUND_DIET_MEAL_RECORD",
    reasonMessage = "존재하지 않는 식단 기록 입니다."
)
