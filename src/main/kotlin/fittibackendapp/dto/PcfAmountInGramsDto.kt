package fittibackendapp.dto

import java.io.Serializable

data class PcfAmountInGramsDto(
    val protein: Double,
    val carbohydrate: Double,
    val fat: Double
): Serializable
