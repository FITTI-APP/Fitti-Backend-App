package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.diet.entity.Diet
import fittibackendapp.dto.DietDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface DietMapStruct : GenericMapStruct<Diet, DietDto>
