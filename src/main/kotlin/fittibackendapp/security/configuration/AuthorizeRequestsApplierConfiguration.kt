package fittibackendapp.common.security.configuration

import fittibackendapp.common.security.type.AuthorizeRequestsApplier
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
