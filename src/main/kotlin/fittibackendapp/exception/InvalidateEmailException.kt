package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class InvalidateEmailException : ResponseStatusReasonException(
    statusCode = HttpStatus.BAD_REQUEST,
    reasonName = "INVALIDATE_EMAIL",
    reasonMessage = "이메일 형식이 맞지 않습니다.",
)
