package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.Exercise
import fittibackendapp.dto.ExerciseDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseMapstruct: GenericMapStruct<Exercise, ExerciseDto>
