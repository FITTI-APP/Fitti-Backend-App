package fittibackendapp.common.datasource

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import fittibackendapp.common.datasource.constant.DriverClass

object HikariDataSourceUtil {
    private fun getJdbcUrl(
        dataSourceConfig: DataSourceConfig,
        driverClass: DriverClass,
    ): String =
        when (driverClass) {
            DriverClass.MYSQL
            -> "jdbc:mysql://${dataSourceConfig.host}:${dataSourceConfig.port}/${dataSourceConfig.dbname}"

            else -> throw IllegalArgumentException("Not supported driver class: $driverClass")
        }

    fun createHikariDataSource(
        poolName: String,
        dataSourceConfig: DataSourceConfig,
        driverClass: DriverClass,
    ): HikariDataSource {
        val hikariConfig = HikariConfig().apply {
            this.poolName = poolName
            this.driverClassName = driverClass.className
            this.username = dataSourceConfig.username
            this.password = dataSourceConfig.password
            this.jdbcUrl = getJdbcUrl(dataSourceConfig, driverClass)
        }
        return HikariDataSource(hikariConfig)
    }
}

