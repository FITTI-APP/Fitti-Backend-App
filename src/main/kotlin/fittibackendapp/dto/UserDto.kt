package fittibackendapp.dto

import java.io.Serializable

/**
 * DTO for {@link fittibackendapp.domain.auth.entity.User}
 */
data class UserDto(
    val name: String,
    val email: String,
    val password: String? = null,
    val role: RoleDto,
    val loginType: LoginTypeDto,
    val id: Long
): Serializable
