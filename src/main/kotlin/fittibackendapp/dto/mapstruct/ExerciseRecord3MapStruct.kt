package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.ExerciseRecord3
import fittibackendapp.dto.ExerciseRecord3Dto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseRecord3MapStruct: GenericMapStruct<ExerciseRecord3, ExerciseRecord3Dto>
