package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.ExerciseSaveType
import fittibackendapp.dto.ExerciseSaveTypeDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseSaveTypeMapStruct: GenericMapStruct<ExerciseSaveType, ExerciseSaveTypeDto>
