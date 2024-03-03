package fittibackendapp.domain.auth.service

import fittibackendapp.domain.auth.repository.LoginTypeRepository
import fittibackendapp.domain.auth.repository.RoleRepository
import fittibackendapp.domain.auth.repository.UserRepository
import fittibackendapp.dto.UserDto
import fittibackendapp.dto.mapstruct.UserMapStruct
import org.springframework.stereotype.Controller

@Controller
class UserService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val loginTypeRepository: LoginTypeRepository,
    private val userMapStruct: UserMapStruct,
) {

    fun getByEmailOrNull(
        email: String
    ): UserDto? {
        val user = userRepository.findByEmail(email)
        return user?.let { userMapStruct.toDto(it) }
    }
}
