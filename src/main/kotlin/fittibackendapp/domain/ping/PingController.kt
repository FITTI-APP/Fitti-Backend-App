package fittibackendapp.domain.ping

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/connection")
class PingController {

    @Operation(
        summary = "연결상태 확인",
        responses = [
            ApiResponse(responseCode = "200", description = "OK"),
        ],

        )
    @GetMapping("/ping")
    fun ping(): String {
        return "pong"
    }
}
