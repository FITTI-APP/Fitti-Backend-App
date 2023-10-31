package fittibackendapp.dto

import java.io.Serializable
import java.time.LocalDateTime

data class DietRecordDto(
    val userId: Long,
    val dateTime: LocalDateTime,
    val memo: String,
    val id: Long
): Serializable
