package fittibackendapp.domain.auth.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import fittibackendapp.common.exception.NotRegisteredEmailException
import fittibackendapp.common.exception.UnCorrectedPasswordException
import fittibackendapp.domain.auth.entity.User
import fittibackendapp.domain.auth.repository.RoleRepository
import fittibackendapp.domain.auth.repository.UserRepository
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
    fun register(
        email: String,
        password: String,
        name: String,
    ): Long {
        val role = roleRepository.findByName("ROLE_USER") ?: throw RuntimeException("ROLE_USER가 없습니다.")

        val user = User(
            email = email,
            password = passwordEncoder.encode(password),
            name = name,
            role = role,
        ).apply {
            userRepository.save(this)
        }

        return user.id!!
    }

    @Transactional
    fun login(
        email: String,
        password: String,
    ): String {
        val user = userRepository.findByEmail(email) ?: throw NotRegisteredEmailException()

        if (!passwordEncoder.matches(password, user.password)) {
            throw UnCorrectedPasswordException()
        }

        return JWT.create()
            .withClaim("email", email)
            .withClaim("password", user.password)
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
    }
}
