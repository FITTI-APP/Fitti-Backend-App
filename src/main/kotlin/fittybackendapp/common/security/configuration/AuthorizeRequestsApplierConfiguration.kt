package fittybackendapp.common.security.configuration

import fittybackendapp.common.security.type.AuthorizeRequestsApplier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AuthorizeRequestsApplierConfiguration {

    @Bean
    fun authorizeRequestsApplier(): AuthorizeRequestsApplier {
        return { http ->
            http.authorizeHttpRequests()
                .requestMatchers(
                    *URLS_ADMIN,
                    *URLS_GRAPHQL,
                    *URLS_DOCUMENT,
                )
                .permitAll()
                .anyRequest() // todo 나중을 기약
                .authenticated()
        }
    }

    companion object {
        private val URLS_AUTHENTICATION = arrayOf(
            "auth",
            "auth/register",
            "auth/login",
        )
        private val URLS_GRAPHQL = arrayOf(
            "graphql",
        )
        private val URLS_ADMIN = arrayOf(
            "admin",
        )
        private val URLS_DOCUMENT = arrayOf(
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/graphiql",
        )
    }
}
