package fittibackendapp.dto.mapstruct

import fittibackendapp.domain.exercise.entity.ExerciseExerciseRecord
import fittibackendapp.dto.ExerciseExerciseRecordDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface ExerciseExerciseRecordMapStruct: GenericMapStruct<ExerciseExerciseRecord, ExerciseExerciseRecordDto>
