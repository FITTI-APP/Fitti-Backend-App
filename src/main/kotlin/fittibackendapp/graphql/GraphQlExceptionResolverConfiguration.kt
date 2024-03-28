package fittibackendapp.graphql

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import graphql.GraphQLError
import graphql.GraphqlErrorBuilder
import graphql.schema.DataFetchingEnvironment
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter

@Configuration
class GraphQlExceptionResolverConfiguration(
    private val errorAttributeMapResolver: ErrorAttributeMapResolver,
): DataFetcherExceptionResolverAdapter() {
    override fun resolveToSingleError(error: Throwable, env: DataFetchingEnvironment): GraphQLError {
        val message: String? =
            if (error is ResponseStatusReasonException)
                error.reasonMessage
            else error.message

        val errorAttribute = GraphQLErrorAttribute(
            message = message,
            path = env.executionStepInfo.path,
            location = env.field.sourceLocation,
        )
        val extensions = errorAttributeMapResolver.getExtensions(error)

        errorAttributeMapResolver.logError(
            error = error,
            extensions = extensions,
            errorAttribute = errorAttribute,
        )

        return GraphqlErrorBuilder
            .newError()
            .message(errorAttribute.message)
            .path(errorAttribute.path)
            .location(errorAttribute.location)
            .extensions(extensions)
            .build()
    }
}

