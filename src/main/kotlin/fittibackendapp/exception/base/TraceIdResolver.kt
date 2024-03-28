package fittibackendapp.exception.base

import io.micrometer.tracing.Tracer
import org.springframework.stereotype.Component

@Component
class TraceIdResolver(
    private val tracer: Tracer,
) {
    fun getTraceIdOrNull(): String? {
        val span = tracer.currentSpan() ?: return null
        return span.context().traceId()
    }
}
