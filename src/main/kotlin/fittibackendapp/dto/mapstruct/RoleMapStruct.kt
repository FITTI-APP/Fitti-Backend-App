package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.auth.entity.Role
import fittibackendapp.dto.RoleDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface RoleMapStruct: GenericMapStruct<Role, RoleDto>
