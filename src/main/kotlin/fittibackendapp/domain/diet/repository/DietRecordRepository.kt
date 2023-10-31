package fittibackendapp.domain.diet.repository

import fittibackendapp.domain.diet.entity.DietRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate

interface DietRecordRepository : JpaRepository<DietRecord, Long>{
    @Query("SELECT e FROM DietRecord e WHERE e.userId = :userId AND e.dateTime BETWEEN :fromDate AND :toDate")
    fun findDietRecordsBetweenTwoDays(
        @Param("userId") userId: Long,
        @Param("fromDate") fromDate: LocalDate,
        @Param("toDate") toDate: LocalDate
    ): List<DietRecord>
}
