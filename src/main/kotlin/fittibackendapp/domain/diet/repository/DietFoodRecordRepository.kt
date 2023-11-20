package fittibackendapp.domain.diet.repository

import fittibackendapp.domain.diet.entity.DietFoodRecord
import org.springframework.data.jpa.repository.JpaRepository

interface DietFoodRecordRepository: JpaRepository<DietFoodRecord, Long> {
    fun findAllByDietMealRecordId(dietMealRecordId: Long): List<DietFoodRecord>

    fun findAllByDietMealRecordIdIn(dietMealRecordIds: List<Long>): List<DietFoodRecord>
}
