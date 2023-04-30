package fittybackendapp.common.datasource

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
class JpaDataSourceConfiguration {
    @Primary
    @Bean
    fun dataSource(): DataSource{ // todo datasource docker 설정 후 
        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName("org.h2.Driver")
        dataSourceBuilder.url("jdbc:h2:mem:test")
        dataSourceBuilder.username("SA")
        dataSourceBuilder.password("")
        return dataSourceBuilder.build()
    }
}