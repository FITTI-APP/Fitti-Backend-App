package fittibackendapp.domain.auth.controller.request

data class RegisterRequest(
    val email: String,
    val password: String,
    val name: String,
)
