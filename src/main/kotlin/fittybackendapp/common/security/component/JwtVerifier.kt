package fittybackendapp.common.security.component

import com.auth0.jwt.interfaces.JWTVerifier
import fittybackendapp.common.dto.TokenDto
import jakarta.servlet.http.HttpServletRequest

interface JwtVerifier {
    val tokenVerifier: JWTVerifier

    fun verify(request: HttpServletRequest): TokenDto?

    fun verifyToken(bearerToken: String): TokenDto
}
