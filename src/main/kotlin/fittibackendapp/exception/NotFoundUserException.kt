package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class NotFoundUserException: ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "NOT_FOUND_USER",
    reasonMessage = "존재하지 않는 유저입니다.",
)
