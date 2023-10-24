package fittibackendapp.common.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class NotRegisteredEmailException : ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "NOT_REGISTERED_EMAIL",
    reasonMessage = "등록되지 않은 이메일입니다.",
)
