package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.ExerciseSetRecord
import fittibackendapp.dto.ExerciseSetRecordDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseSetRecordMapStruct: GenericMapStruct<ExerciseSetRecord, ExerciseSetRecordDto>
