package fittybackendapp.common.exception.base

import org.springframework.http.HttpStatusCode

data class ExceptionReasonDto(
    val status: HttpStatusCode,
    val reason: String,
    val message: String,
)
