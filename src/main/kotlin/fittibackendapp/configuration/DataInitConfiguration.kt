package fittibackendapp.common.configuration

import fittibackendapp.domain.auth.entity.Role
import fittibackendapp.domain.auth.repository.RoleRepository
import org.springframework.boot.context.event.ApplicationStartingEvent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

@Configuration
class DataInitConfiguration(
    private val roleRepository: RoleRepository
) {
    @Bean
    @Transactional
    @TransactionalEventListener(ApplicationStartingEvent::class)
    @EventListener(ApplicationStartingEvent::class)
    fun initEnumData() {
        if (roleRepository.findByName("ROLE_USER") == null)
            roleRepository.save(Role(name = "ROLE_USER"))

        if (roleRepository.findByName("ROLE_ADMIN") == null)
            roleRepository.save(Role(name = "ROLE_ADMIN"))
    }
}
