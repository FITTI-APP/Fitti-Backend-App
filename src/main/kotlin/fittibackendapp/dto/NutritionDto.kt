package fittibackendapp.dto

import java.io.Serializable

data class NutritionDto(
    val name: String,
    val protein: Double,
    val fat: Double,
    val carbohydrate: Double,
    val id: Long
): Serializable
