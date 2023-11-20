package fittibackendapp.domain.diet.service

import fittibackendapp.domain.diet.repository.DietMealRecordRepository
import fittibackendapp.dto.DietMealRecordDto
import fittibackendapp.dto.mapstruct.DietMealRecordMapStruct
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DietMealRecordService(
    private val dietMealRecordRepository: DietMealRecordRepository,
    private val dietMealRecordMapStruct: DietMealRecordMapStruct
) {
    fun findDietMealRecordsBetweenDays(userId: Long, fromDate: LocalDate, toDate: LocalDate): List<DietMealRecordDto> {
        val dietMealRecords = dietMealRecordRepository.findDietMealRecordsBetweenDays(userId, fromDate, toDate)
        return dietMealRecordMapStruct.toDtos(dietMealRecords)
    }
}
