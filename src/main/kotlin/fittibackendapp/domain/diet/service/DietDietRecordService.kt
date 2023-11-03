package fittibackendapp.domain.diet.service

import fittibackendapp.domain.diet.repository.DietDietRecordRepository
import fittibackendapp.dto.DietDietRecordDto
import fittibackendapp.dto.mapstruct.DietDietRecordMapStruct
import org.springframework.stereotype.Service

@Service
class DietDietRecordService(
    private val dietDietRecordRepository: DietDietRecordRepository,
    private val dietDietRecordMapStruct: DietDietRecordMapStruct
) {
    fun findAllByDietRecordId(dietRecordId: Long): List<DietDietRecordDto> {
        val dietDietRecords = dietDietRecordRepository.findAllByDietRecordId(dietRecordId)
        return dietDietRecordMapStruct.toDtos(dietDietRecords)
    }

    fun findAllByDietRecordIds(dietRecordIds: List<Long>): List<DietDietRecordDto> {
        val dietDietRecords = dietDietRecordRepository.findAllByDietRecordIdIn(dietRecordIds)
        return dietDietRecordMapStruct.toDtos(dietDietRecords)
    }
}
