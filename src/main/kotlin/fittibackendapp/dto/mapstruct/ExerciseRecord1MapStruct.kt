package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.ExerciseRecord1
import fittibackendapp.dto.ExerciseRecord1Dto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseRecord1MapStruct: GenericMapStruct<ExerciseRecord1, ExerciseRecord1Dto>
