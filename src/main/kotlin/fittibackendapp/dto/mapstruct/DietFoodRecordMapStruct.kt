package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.diet.entity.DietFoodRecord
import fittibackendapp.dto.DietFoodRecordDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface DietFoodRecordMapStruct: GenericMapStruct<DietFoodRecord, DietFoodRecordDto>
