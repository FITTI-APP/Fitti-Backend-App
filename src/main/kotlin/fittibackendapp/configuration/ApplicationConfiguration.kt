package fittibackendapp.common.configuration

import fittibackendapp.common.constant.FittiBackendApp
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class ApplicationConfiguration(
    private val environment: Environment,
) {
    @Bean(BeanName.PROJECT_NAME)
    fun projectName(): String = FittiBackendApp.PROJECT_NAME

    @Bean(BeanName.PROFILE)
    fun profile(): String = environment
        .activeProfiles
        .first { it != FittiBackendApp.Profile.COMMON && it != FittiBackendApp.Profile.CRON }

    @Bean(BeanName.IS_LOCAL)
    fun isLocal(): Boolean = profile() == FittiBackendApp.Profile.LOCAL

    // @Bean(BeanName.MODULE_NAME)
    // fun moduleName() = environment.getProperty("module.name")!!

    object BeanName {
        const val PROFILE = "profile"
        const val PROJECT_NAME = "projectName"
        const val IS_LOCAL = "isLocal"
        const val MODULE_NAME = "moduleName"
    }
}
