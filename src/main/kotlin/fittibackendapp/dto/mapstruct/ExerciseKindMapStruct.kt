package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.ExerciseKind
import fittibackendapp.dto.ExerciseKindDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseKindMapStruct: GenericMapStruct<ExerciseKind, ExerciseKindDto>
