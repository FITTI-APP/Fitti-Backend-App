package fittibackendapp.security.oauth2

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import java.nio.charset.StandardCharsets

@Component
class MyAuthenticationSuccessHandler: AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val oAuth2User = authentication.principal as OAuth2User
        response.sendRedirect(
            UriComponentsBuilder.fromUriString(REDIRECT_URI)
                .queryParam("accessToken", "accessToken")
                .queryParam("refreshToken", "refreshToken")
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUriString(),
        )
    }

    companion object {
        const val REDIRECT_URI = "http://localhost:3000/logincheck"
    }
}
