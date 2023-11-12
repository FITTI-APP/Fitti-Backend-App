package fittibackendapp.domain.diet.repository

import fittibackendapp.domain.diet.entity.DietMealRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate

interface DietMealRecordRepository: JpaRepository<DietMealRecord, Long> {
    @Query("SELECT e FROM DietMealRecord e WHERE e.userId = :userId AND e.dateTime BETWEEN :fromDate AND :toDate")
    fun findDietMealRecordsBetweenDays(
        @Param("userId")
        userId: Long,
        @Param("fromDate")
        fromDate: LocalDate,
        @Param("toDate")
        toDate: LocalDate
    ): List<DietMealRecord>
}
