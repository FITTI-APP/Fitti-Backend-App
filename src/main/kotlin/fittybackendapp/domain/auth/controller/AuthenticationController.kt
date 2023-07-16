package fittybackendapp.domain.auth.controller

import fittybackendapp.domain.auth.service.AuthenticationService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(
    private val authenticationService: AuthenticationService,
) {
    // @Operation(
    //     summary = "Fitty 로그인",
    //     responses = [
    //         ApiResponse(responseCode = "200", description = "OK"),
    //     ],
    // )
    // @PostMapping("/login")
    // fun login(
    //     @RequestBody
    //     loginRequest: LoginRequest,
    // ): LoginResponse {
    //     return authenticationService.login(
    //         email = loginRequest.email,
    //         password = loginRequest.password,
    //     )
    // }
}
