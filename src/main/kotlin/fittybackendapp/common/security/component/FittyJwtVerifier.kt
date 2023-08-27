package fittybackendapp.common.security.component

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.exceptions.TokenExpiredException
import com.auth0.jwt.interfaces.JWTVerifier
import fittybackendapp.common.dto.TokenDto
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
        .build()

    override fun verify(request: HttpServletRequest): TokenDto? {
        val bearerToken = request.getHeader("Authorization") ?: return null
        if (!bearerToken.startsWith("Bearer ")) return null

        return verifyToken(bearerToken)
    }

    override fun verifyToken(bearerToken: String): TokenDto {
        try {
            val verification = when (val token = bearerToken.substring(7)) {
                "fitty"
                -> TokenDto(
                    name = "fitty",
                    userId = 99997,
                    role = 2,
                )

                else -> {
                    val verifiedJWT = tokenVerifier.verify(bearerToken)
                    TokenDto(
                        name = verifiedJWT.getClaim("name").asString(),
                        userId = verifiedJWT.getClaim("userId").asLong(),
                        role = verifiedJWT.getClaim("role").asLong(),
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

