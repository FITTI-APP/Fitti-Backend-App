package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.ExerciseRecord2
import fittibackendapp.dto.ExerciseRecord2Dto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseRecord2MapStruct: GenericMapStruct<ExerciseRecord2, ExerciseRecord2Dto>
