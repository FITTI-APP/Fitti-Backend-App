package fittibackendapp.dto

import java.io.Serializable

data class TargetPcfRatioDto(
    val protein: Double,
    val carbohydrate: Double,
    val fat: Double,
    val id: Long
): Serializable
