package fittybackendapp.domain.auth.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthenticationService {
    @Transactional
    fun login(
        email: String,
        password: String,
    ) {
    }
}
