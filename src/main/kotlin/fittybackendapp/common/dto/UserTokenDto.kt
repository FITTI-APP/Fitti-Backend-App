package fittybackendapp.common.dto

import fittybackendapp.common.enums.Role

data class UserTokenDto(
    override val name: String,
    override val userId: Long,
    val role: Role
): TokenDto

