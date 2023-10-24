package fittibackendapp.common.datasource.constant

enum class DriverClass(val className: String) {
    POSTGRESQL("org.postgresql.Driver"),
    SQL_SERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    MYSQL("com.mysql.cj.jdbc.Driver"),
}
