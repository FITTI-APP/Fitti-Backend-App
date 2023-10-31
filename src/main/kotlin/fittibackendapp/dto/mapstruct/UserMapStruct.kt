package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.auth.entity.User
import fittibackendapp.dto.UserDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface UserMapStruct: GenericMapStruct<User, UserDto>
