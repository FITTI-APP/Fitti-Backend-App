package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.diet.entity.DietMealRecord
import fittibackendapp.dto.DietMealRecordDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface DietMealRecordMapStruct: GenericMapStruct<DietMealRecord, DietMealRecordDto>
