package fittybackendapp.common.security.component

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.exceptions.TokenExpiredException
import com.auth0.jwt.interfaces.JWTVerifier
import fittybackendapp.common.dto.TokenDto
import fittybackendapp.common.dto.UserTokenDto
import fittybackendapp.common.enums.Role
import fittybackendapp.common.exception.JwtTokenExpiredException
import fittybackendapp.common.security.configuration.AuthenticateFailedException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component

@Component
class FittyJwtVerifier(
    private val tokenAlgorithm: Algorithm,
): JwtVerifier {
    override val tokenVerifier: JWTVerifier = JWT
        .require(tokenAlgorithm)
        .withClaimPresence("name")
        .withClaimPresence("userId")
        .withClaimPresence("role")
        .build()

    override fun verify(request: HttpServletRequest): TokenDto? {
        val bearerToken = request.getHeader("Authorization") ?: return null
        if (!bearerToken.startsWith("Bearer ")) return null

        return verifyToken(bearerToken)
    }

    override fun verifyToken(bearerToken: String): UserTokenDto {
        try {
            val verification = when (val token = bearerToken.substring(7)) {
                // 개발
                "almighty"
                -> UserTokenDto(
                    name = "almighty",
                    userId = 99997,
                    role = Role.ADMIN,
                )

                // QA 토큰
                "qalmighty"
                -> UserTokenDto(
                    name = "qalmighty",
                    userId = 99999,
                    role = Role.USER,
                )

                else -> {
                    val verifiedJWT = tokenVerifier.verify(bearerToken)
                    UserTokenDto(
                        name = verifiedJWT.getClaim("name").asString(),
                        userId = verifiedJWT.getClaim("userId").asLong(),
                        role = Role.valueOf(verifiedJWT.getClaim("role").asString()),
                    )
                }
            }
            return verification
        } catch (e: TokenExpiredException) {
            throw JwtTokenExpiredException()
        } catch (e: JWTVerificationException) {
            throw AuthenticateFailedException()
        }
    }
}

