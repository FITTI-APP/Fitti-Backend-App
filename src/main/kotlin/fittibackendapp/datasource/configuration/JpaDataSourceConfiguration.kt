package fittibackendapp.common.datasource.configuration

import fittibackendapp.common.configuration.ApplicationConfiguration
import fittibackendapp.common.configuration.ReflectionConfiguration
import fittibackendapp.common.constant.FittiBackendApp
import fittibackendapp.common.datasource.DataSourceConfig
import fittibackendapp.common.datasource.HikariDataSourceUtil
import fittibackendapp.common.datasource.constant.DriverClass
import org.hibernate.cfg.AvailableSettings
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
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
    private val beanFactory: ConfigurableListableBeanFactory,
    @Qualifier(DataEntryPointConfiguration.BeanName.DATA_SOURCE_CONFIG)
    private val dataSourceConfig: DataSourceConfig,
) {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    fun dataSource(): DataSource { // todo datasource docker 설정 후

        // secretsManagerService.getDataSourceConfig(profile) todo
        val dataSource = HikariDataSourceUtil.createHikariDataSource(
            poolName = FittiBackendApp.PROJECT,
            dataSourceConfig = dataSourceConfig,
            driverClass = DriverClass.MYSQL,
        )

        return dataSource
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
        em.persistenceUnitName = FittiBackendApp.PROJECT
        return em
    }

    @Primary
    @Bean
    fun transactionManager(): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory().`object`
        transactionManager.persistenceUnitName = FittiBackendApp.PROJECT
        return transactionManager
    }
}
