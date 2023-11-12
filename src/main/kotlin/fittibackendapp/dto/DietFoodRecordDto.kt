package fittibackendapp.dto

import java.io.Serializable

data class DietFoodRecordDto(
    val dietMealRecord: DietMealRecordDto,
    val weight: Long,
    val nutrition: NutritionDto,
    val id: Long
): Serializable
