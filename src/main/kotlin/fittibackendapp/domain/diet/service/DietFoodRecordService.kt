package fittibackendapp.domain.diet.service

import fittibackendapp.domain.diet.repository.DietFoodRecordRepository
import fittibackendapp.dto.DietFoodRecordDto
import fittibackendapp.dto.mapstruct.DietFoodRecordMapStruct
import org.springframework.stereotype.Service

@Service
class DietFoodRecordService(
    private val dietFoodRecordRepository: DietFoodRecordRepository,
    private val dietFoodRecordMapStruct: DietFoodRecordMapStruct
) {
    fun findAllByDietMealRecordId(dietMealRecordId: Long): List<DietFoodRecordDto> {
        val dietFoodRecords = dietFoodRecordRepository.findAllByDietMealRecordId(dietMealRecordId)
        return dietFoodRecordMapStruct.toDtos(dietFoodRecords)
    }

    fun findAllByDietMealRecordIds(dietMealRecordIds: List<Long>): List<DietFoodRecordDto> {
        val dietFoodRecords = dietFoodRecordRepository.findAllByDietMealRecordIdIn(dietMealRecordIds)
        return dietFoodRecordMapStruct.toDtos(dietFoodRecords)
    }
}
