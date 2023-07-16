package fittybackendapp.domain.auth.controller.request

import io.swagger.v3.oas.annotations.media.Schema

class LoginRequest(
    @Schema(
        description = """[필수] 로그인 할 계정의 이메일입니다.""",
    )
    val email: String,

    @Schema(
        description = """[필수] 로그인 할 계정의 비밀번호입니다.""",
    )
    val password: String,
)
