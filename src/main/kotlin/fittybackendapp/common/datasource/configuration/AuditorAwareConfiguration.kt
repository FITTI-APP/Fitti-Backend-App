package fittybackendapp.common.datasource.configuration

import fittybackendapp.common.dto.TokenDto
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.core.context.SecurityContextHolder
import java.util.Optional

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
class AuditorAwareConfiguration {
    @Bean
    fun auditorAware(): AuditorAware<Long> {
        return AuditorAware<Long> {
            val authentication = SecurityContextHolder.getContext().authentication
            // val token = authentication.principal as TokenDto todo
            val token = TokenDto(userId = 1, name = "ROLE_USER")
            Optional.of(token.userId)
        }
    }
}
