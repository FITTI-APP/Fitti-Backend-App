package fittibackendapp.domain.diet.repository

import fittibackendapp.domain.diet.entity.DietDietRecord
import org.springframework.data.jpa.repository.JpaRepository

interface DietDietRecordRepository : JpaRepository<DietDietRecord, Long>{
    fun findAllByDietRecordId(dietRecordId: Long): List<DietDietRecord>

    fun findAllByDietRecordIdIn(dietRecordIds: List<Long>): List<DietDietRecord>
}
