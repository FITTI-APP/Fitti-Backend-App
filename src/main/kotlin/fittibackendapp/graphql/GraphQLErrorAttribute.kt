package fittibackendapp.graphql

import graphql.execution.ResultPath
import graphql.language.SourceLocation

data class GraphQLErrorAttribute(
    val message: String?,
    val path: ResultPath,
    val location: SourceLocation,
)
