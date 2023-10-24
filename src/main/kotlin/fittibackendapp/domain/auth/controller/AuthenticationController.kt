package fittibackendapp.domain.auth.controller

import fittibackendapp.domain.auth.controller.request.LoginRequest
import fittibackendapp.domain.auth.controller.request.RegisterRequest
import fittibackendapp.domain.auth.controller.response.LoginResponse
import fittibackendapp.domain.auth.controller.response.RegisterResponse
import fittibackendapp.domain.auth.service.AuthenticationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(
    private val authenticationService: AuthenticationService,
) {
    @Operation(
        summary = "fitti 로그인",
        description = """회원가입에서 등록한 이메일과 비밀번호를 입력하여 로그인합니다.
            |로그인 성공 시, JWT 토큰을 발급합니다.
            |JWT 토큰은 1일간 유효합니다.
            |발급받은 JWT 토큰은 Authorization 헤더에 Bearer 키워드와 함께 전달해야 합니다.
            |todo 후에 Refresh Token 기능을 추가할 예정입니다.(미구현)
        """,
        responses = [
            ApiResponse(responseCode = "200", description = "OK"),
        ],

        )
    @PostMapping("/login")
    fun login(
        @RequestBody
        loginRequest: LoginRequest,
    ): LoginResponse {
        val token = authenticationService.login(
            email = loginRequest.email,
            password = loginRequest.password,
        )
        return LoginResponse(token = token)
    }

    @Operation(
        summary = "fitti 회원가입",
        description = """회원가입을 합니다.
            |이메일과 비밀번호 그리고 이름을 입력하여 회원가입을 합니다.
            |이메일은 중복될 수 없습니다.
            |비밀번호는 8자리 이상이어야 하며 영문, 숫자, 특수문자중 2가지 이상 포함되어야 합니다.
            |todo 아직 위의 validation은 구현되어 있지 않습니다.
        """,
        responses = [
            ApiResponse(responseCode = "200", description = "OK"),
        ],

        )
    @PostMapping("/register")
    fun register(
        @RequestBody
        registerRequest: RegisterRequest,
    ): RegisterResponse {
        val userId = authenticationService.register(
            email = registerRequest.email,
            password = registerRequest.password,
            name = registerRequest.name,
        )
        return RegisterResponse(userId = userId)
    }
}
