package fittibackendapp.dto

import java.io.Serializable

data class PcfRatioDto(
    val proteinRatio: Double,
    val carbohydrateRatio: Double,
    val fatRatio: Double
): Serializable
