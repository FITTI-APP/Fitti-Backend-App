package fittybackendapp.domain.auth.service

import fittybackendapp.domain.auth.controller.response.LoginResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthenticationService {
    @Transactional
    fun login(
        email: String,
        password: String,
    ): LoginResponse {
        return LoginResponse(
            token = "안녕하세요!!! 아직 완성 안되었습니다.",
        )
    }
}
