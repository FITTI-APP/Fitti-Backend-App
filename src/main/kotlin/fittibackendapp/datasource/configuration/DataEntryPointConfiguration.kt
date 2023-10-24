package fittibackendapp.common.datasource.configuration

import fittibackendapp.common.datasource.DataSourceConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class DataEntryPointConfiguration(
    private val environment: Environment
) {

    @Bean(BeanName.DATA_SOURCE_CONFIG)
    fun dataSourceConfig(): DataSourceConfig = DataSourceConfig(
        username = environment.getProperty("spring.datasource.username")!!,
        password = environment.getProperty("spring.datasource.password")!!,
        engine = environment.getProperty("spring.datasource.engine")!!,
        host = environment.getProperty("spring.datasource.host")!!,
        port = environment.getProperty("spring.datasource.port")!!,
        dbname = environment.getProperty("spring.datasource.dbname")!!,
    )

    object BeanName {
        const val DATA_SOURCE_CONFIG = "dataSourceConfig"
    }
}
