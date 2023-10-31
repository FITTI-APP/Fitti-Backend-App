package fittibackendapp.domain.diet.service

import fittibackendapp.domain.diet.entity.DietRecord
import fittibackendapp.domain.diet.repository.DietDietRecordRepository
import fittibackendapp.domain.diet.repository.DietRecordRepository
import fittibackendapp.domain.diet.repository.DietRepository
import fittibackendapp.dto.DietRecordDto
import fittibackendapp.dto.PcfAmountInGramsDto
import fittibackendapp.dto.mapstruct.DietRecordMapStruct
import fittibackendapp.exception.NotFoundDietException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DietRecordService (
    private val dietRecordRepository: DietRecordRepository,
    private val dietRecordMapStruct: DietRecordMapStruct
){
    fun findDietRecordsBetweenTwoDays(userId: Long, fromDate: LocalDate, toDate: LocalDate): List<DietRecordDto> {
        val dietRecords = dietRecordRepository.findDietRecordsBetweenTwoDays(userId, fromDate, toDate)
        return dietRecordMapStruct.toDtos(dietRecords)
    }
}
