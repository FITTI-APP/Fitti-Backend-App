package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class InvalidatePasswordException : ResponseStatusReasonException(
    statusCode = HttpStatus.BAD_REQUEST,
    reasonName = "INVALIDATE_PASSWORD",
    reasonMessage = "비밀번호 형식이 맞지 않습니다.",
)
