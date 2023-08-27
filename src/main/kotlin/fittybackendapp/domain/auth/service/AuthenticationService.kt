package fittybackendapp.domain.auth.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import fittybackendapp.common.exception.NotRegisteredEmailException
import fittybackendapp.common.exception.UnCorrectedPasswordException
import fittybackendapp.domain.auth.controller.response.LoginResponse
import fittybackendapp.domain.auth.repository.RoleRepository
import fittybackendapp.domain.auth.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Service
class AuthenticationService(
    private val tokenAlgorithm: Algorithm,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    
    @Transactional
    fun login(
        email: String,
        password: String,
    ): LoginResponse {
        val user = userRepository.findByEmail(email) ?: throw NotRegisteredEmailException()

        if (passwordEncoder.matches(password, user.password)) {
            throw UnCorrectedPasswordException()
        }

        val token = JWT.create()
            .withClaim("email", email)
            .withClaim("password", password)
            .withClaim("role", user.role.id)
            .withExpiresAt(
                Date.from(
                    LocalDateTime
                        .now()
                        .plusDays(1)
                        .atZone(ZoneId.of("Asia/Seoul"))
                        .toInstant(),
                ),
            )
            .sign(tokenAlgorithm)

        return LoginResponse(
            token = token,
        )
    }
}
