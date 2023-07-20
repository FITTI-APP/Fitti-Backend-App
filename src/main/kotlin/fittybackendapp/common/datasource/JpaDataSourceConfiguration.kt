package fittybackendapp.common.datasource

import fittybackendapp.common.configuration.ApplicationConfiguration
import fittybackendapp.common.configuration.ReflectionConfiguration
import fittybackendapp.common.constant.FittyBackendApp
import fittybackendapp.common.datasource.constant.DriverClass
import org.hibernate.cfg.AvailableSettings
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import org.springframework.orm.hibernate5.SpringBeanContainer
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
class JpaDataSourceConfiguration(
    // private val secretsManagerService: SecretsManagerService,
    @Qualifier(ReflectionConfiguration.BeanName.BASE_PACKAGE)
    private val entityBasePackage: String,
    @Qualifier(ApplicationConfiguration.BeanName.PROFILE)
    private val profile: String,
    private val beanFactory: ConfigurableListableBeanFactory
) {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    fun dataSource(): DataSource { // todo datasource docker 설정 후
        val dataSourceConfig = DataSourceConfig(
            username = "fitty",
            password = "fitty",
            engine = "mysql",
            host = "localhost",
            port = "5515",
            dbname = "fitty_database",
        )
        // secretsManagerService.getDataSourceConfig(profile) todo
        val dataSource = HikariDataSourceUtil.createHikariDataSource(
            poolName = FittyBackendApp.PROJECT,
            dataSourceConfig = dataSourceConfig,
            driverClass = DriverClass.MYSQL,
        )

        return LazyConnectionDataSourceProxy(dataSource)
    }

    @Primary
    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = dataSource()
        em.setPackagesToScan(entityBasePackage)
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()
        em.setJpaPropertyMap(
            mapOf(
                AvailableSettings.DIALECT to "org.hibernate.dialect.MySQLDialect",
                AvailableSettings.PHYSICAL_NAMING_STRATEGY to "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy",
                AvailableSettings.BEAN_CONTAINER to SpringBeanContainer(beanFactory),
            ),
        )
        em.persistenceUnitName = FittyBackendApp.PROJECT
        return em
    }

    @Primary
    @Bean
    fun transactionManager(): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory().`object`
        transactionManager.persistenceUnitName = FittyBackendApp.PROJECT
        return transactionManager
    }
}
