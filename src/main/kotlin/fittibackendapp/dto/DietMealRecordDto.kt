package fittibackendapp.dto

import java.io.Serializable
import java.time.LocalDateTime

data class DietMealRecordDto(
    val userId: Long,
    val dateTime: LocalDateTime,
    val memo: String,
    val id: Long
): Serializable
