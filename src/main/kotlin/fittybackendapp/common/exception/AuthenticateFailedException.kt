package fittybackendapp.common.exception

import fittybackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class AuthenticateFailedException: ResponseStatusReasonException(
    statusCode = HttpStatus.UNAUTHORIZED,
    reasonName = "AUTHENTICATION_FAILED",
    reasonMessage = "잘못된 인증 정보입니다.",
)
