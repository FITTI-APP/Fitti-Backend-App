package fittibackendapp.common.configuration

import org.reflections.Reflections
import org.reflections.util.ConfigurationBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ReflectionConfiguration {
    @Bean(BeanName.BASE_PACKAGE)
    fun basePackage(): String = BASE_PACKAGE

    @Bean
    fun reflections(): Reflections = Reflections(ConfigurationBuilder().forPackages(basePackage()))

    object BeanName {
        const val BASE_PACKAGE = "basePackage"
    }

    companion object {
        const val BASE_PACKAGE = "fittibackendapp"
    }
}
