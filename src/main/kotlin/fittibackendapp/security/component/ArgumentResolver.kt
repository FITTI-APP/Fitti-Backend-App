package fittibackendapp.security.component

import fittibackendapp.common.dto.TokenDto
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class ArgumentResolver {
    private fun getTokenOrNull(): TokenDto? {
        val s = SecurityContextHolder.getContext().authentication.credentials as TokenDto?
        return s
    }

    fun getUserId(): Long {
        return getTokenOrNull()!!.userId
    }
}
