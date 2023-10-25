package fittibackendapp.dto

import java.io.Serializable

/**
 * DTO for {@link fittibackendapp.domain.auth.entity.Role}
 */
data class RoleDto(
    val name: String,
    val id: Long
): Serializable
