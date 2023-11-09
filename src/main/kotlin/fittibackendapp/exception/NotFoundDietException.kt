package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class NotFoundDietException : ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "NOT_FOUND_DIET",
    reasonMessage = "존재하지 않는 식단 입니다.",
)
