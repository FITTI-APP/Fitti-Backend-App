package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.ExerciseSessionRecord
import fittibackendapp.dto.ExerciseSessionRecordDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseSessionRecordMapStruct: GenericMapStruct<ExerciseSessionRecord, ExerciseSessionRecordDto>
