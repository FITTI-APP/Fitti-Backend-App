package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.diet.entity.DietDietRecord
import fittibackendapp.dto.DietDietRecordDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface DietDietRecordMapStruct : GenericMapStruct<DietDietRecord, DietDietRecordDto>
