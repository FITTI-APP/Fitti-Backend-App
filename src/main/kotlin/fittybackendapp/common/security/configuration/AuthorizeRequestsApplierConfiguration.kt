package fittybackendapp.common.security.configuration

import fittybackendapp.common.security.type.AuthorizeRequestsApplier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AuthorizeRequestsApplierConfiguration {

    @Bean
    fun authorizeRequestsApplier(): AuthorizeRequestsApplier {
        return { http ->
            http.authorizeHttpRequests {
                it.anyRequest().permitAll()
            }
        }
    }
}
