package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.diet.entity.DietRecord
import fittibackendapp.dto.DietRecordDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface DietRecordMapStruct  : GenericMapStruct<DietRecord, DietRecordDto>
