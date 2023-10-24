package fittibackendapp.domain.auth.controller.response

import java.io.Serializable

data class LoginResponse(
    val token: String,
): Serializable
