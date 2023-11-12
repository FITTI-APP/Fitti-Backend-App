package fittibackendapp.domain.diet.facade

import fittibackendapp.domain.diet.service.DietFoodRecordService
import fittibackendapp.domain.diet.service.DietMealRecordService
import fittibackendapp.domain.diet.service.NutritionService
import fittibackendapp.dto.PcfAmountInGramsDto
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DietRecordQueryFacade(
    private val nutritionService: NutritionService,
    private val dietMealRecordService: DietMealRecordService,
    private val dietFoodRecordService: DietFoodRecordService
) {
    fun getPcfAmountInGramsBetweenDays(userId: Long, fromDate: LocalDate, toDate: LocalDate): PcfAmountInGramsDto {
        val dietMealRecordIds =
            dietMealRecordService.findDietMealRecordsBetweenDays(userId, fromDate, toDate).map { it.id }
        val dietFoodRecords = dietFoodRecordService.findAllByDietMealRecordIds(dietMealRecordIds)
        val nutritions = nutritionService.findAllByIds(dietFoodRecords.map { it.nutrition.id }.distinct())
        val nutritionMap = nutritions.associateBy { it.id }
        var protein = 0.0
        var carbohydrate = 0.0
        var fat = 0.0
        dietFoodRecords.forEach {
            val nutrition = nutritionMap[it.nutrition.id]!!
            protein += nutrition.protein * it.weight
            carbohydrate += nutrition.carbohydrate * it.weight
            fat += nutrition.fat * it.weight
        }
        return PcfAmountInGramsDto(protein, carbohydrate, fat)
    }
}
