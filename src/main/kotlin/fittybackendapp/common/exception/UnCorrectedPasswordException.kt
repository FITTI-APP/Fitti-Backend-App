package fittybackendapp.common.exception

import fittybackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class UnCorrectedPasswordException: ResponseStatusReasonException(
    statusCode = HttpStatus.BAD_REQUEST,
    reasonName = "UN_CORRECTED_PASSWORD",
    reasonMessage = "비밀번호가 일치하지 않습니다.",
)
