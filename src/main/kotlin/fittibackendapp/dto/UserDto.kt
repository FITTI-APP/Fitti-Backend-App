package fittibackendapp.dto

import java.io.Serializable

/**
 * DTO for {@link fittibackendapp.domain.auth.entity.User}
 */
data class UserDto(
    val name: String,
    val email: String,
    val password: String,
    val role: RoleDto,
    val id: Long
): Serializable
