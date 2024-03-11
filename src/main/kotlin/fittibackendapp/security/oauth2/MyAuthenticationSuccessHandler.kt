package fittibackendapp.security.oauth2

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component

@Component
class MyAuthenticationSuccessHandler(
    private val objectMapper: ObjectMapper
): AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val oAuth2User = authentication.principal as DefaultOAuth2User
        val token = oAuth2User.attributes["token"] as String

        // 토큰 데이터 생성
        val tokenData = mapOf(
            "token" to token,
        )

        // JSON으로 변환
        val json = objectMapper.writeValueAsString(tokenData)

        // 응답 설정
        response.contentType = "application/json;charset=UTF-8"
        response.writer.print(json)
    }

    companion object {
        const val REDIRECT_URI = "http://localhost:3000/logincheck"
    }
}
