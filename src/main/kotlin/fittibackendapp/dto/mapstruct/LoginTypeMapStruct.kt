package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.auth.entity.LoginType
import fittibackendapp.dto.LoginTypeDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface LoginTypeMapStruct: GenericMapStruct<LoginType, LoginTypeDto>
