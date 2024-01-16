package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.diet.entity.TargetPcfRatio
import fittibackendapp.dto.PcfRatioDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface TargetPcfRatioMapStruct: GenericMapStruct<TargetPcfRatio, PcfRatioDto>
