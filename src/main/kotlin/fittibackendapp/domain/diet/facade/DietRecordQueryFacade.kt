package fittibackendapp.domain.diet.facade

import fittibackendapp.domain.diet.service.DietDietRecordService
import fittibackendapp.domain.diet.service.DietRecordService
import fittibackendapp.domain.diet.service.DietService
import fittibackendapp.dto.PcfAmountInGramsDto
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DietRecordQueryFacade (
    private val dietService: DietService,
    private val dietRecordService: DietRecordService,
    private val dietDietRecordService: DietDietRecordService
){
    fun getPcfAmountInGramsBetweenDays(userId: Long, fromDate: LocalDate, toDate: LocalDate) : PcfAmountInGramsDto {
        val dietRecords = dietRecordService.findDietRecordsBetweenTwoDays(userId, fromDate, toDate)
        var protein = 0.0
        var carbohydrate = 0.0
        var fat = 0.0
        dietRecords.forEach { dietRecord ->
            val dietDietRecords = dietDietRecordService.findAllByDietRecordId(dietRecord.id)
            dietDietRecords.forEach {
                val diet = dietService.findById(it.diet.id)
                protein += diet.protein * it.weight
                carbohydrate += diet.carbohydrate * it.weight
                fat += diet.fat * it.weight
            }
        }
        return PcfAmountInGramsDto(protein, carbohydrate, fat)
    }
}
