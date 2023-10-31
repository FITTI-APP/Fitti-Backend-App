package fittibackendapp.dto

import java.io.Serializable

data class DietDietRecordDto(
    val dietRecord: DietRecordDto,
    val weight: Long,
    val diet: DietDto,
    val id: Long
): Serializable
