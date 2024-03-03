package fittibackendapp.domain.auth.controller

import fittibackendapp.domain.auth.facade.OAuth2CustomService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/oauth2")
class GoogleAuthController(
    private val oAuth2CustomService: OAuth2CustomService,
) {

    @Operation(
        summary = "Google Login",
        description = "Google Login /oauth2/authorization/google",
    )
    @GetMapping("/authorization/google")
    fun googleLogin(
        
    ) {
    }
}

