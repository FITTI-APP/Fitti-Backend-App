package fittybackendapp.domain.auth.service

import fittybackendapp.domain.auth.controller.response.LoginResponse
import fittybackendapp.domain.auth.entity.User
import fittybackendapp.domain.auth.repository.RoleRepository
import fittybackendapp.domain.auth.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthenticationService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
) {
    @Transactional
    fun login(
        email: String,
        password: String,
    ): LoginResponse {
        val role = roleRepository.findById(1).get()
        userRepository.save(
            User(
                id = 1,
                name = "이름",
                email = email,
                password = password,
                role = role,
            ),
        )
        return LoginResponse(
            token = "안녕하세요!2!! 아직 완성 안되었습니다.",
        )
    }
}
