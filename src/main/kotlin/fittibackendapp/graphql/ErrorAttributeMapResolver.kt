package fittibackendapp.graphql

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import fittibackendapp.exception.base.TraceIdResolver
import fittibackendapp.security.component.ArgumentResolver
import mu.KotlinLogging
// import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class ErrorAttributeMapResolver(
    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    private val argumentResolver: ArgumentResolver,
    private val traceIdResolver: TraceIdResolver,
) {
    val logger = KotlinLogging.logger {}

    fun getExtensions(error: Throwable): Map<String, String?> {
        val errorAttributes = mutableMapOf<String, String?>()

        errorAttributes["traceId"] = traceIdResolver.getTraceIdOrNull()
        // TODO: 토큰 없이 진입할 때 clientId를 어떻게 처리해야할까
        // errorAttributes["clientId"] = argumentResolver.resolveIdOrNull()

        if (error is ResponseStatusReasonException)
            errorAttributes["reason"] = error.reasonMessage

        return errorAttributes
    }

    fun logError(
        error: Throwable,
        extensions: Map<String, String?>,
        errorAttribute: Any,
    ) {
        logger.error(
            """
            |extensions: $extensions
            |attributes: $errorAttribute
            |stacktrace: ${error.stackTrace.joinToString("\n") { "at $it" }}
            """.trimMargin(),
        )
    }
}
