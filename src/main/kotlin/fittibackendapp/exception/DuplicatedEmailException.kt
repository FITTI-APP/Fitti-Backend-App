package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class DuplicatedEmailException : ResponseStatusReasonException(
    statusCode = HttpStatus.BAD_REQUEST,
    reasonName = "DUPLICATED_EMAIL",
    reasonMessage = "이미 존재하는 이메일 입니다.",
)
