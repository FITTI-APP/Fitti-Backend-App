package fittibackendapp.domain.diet.repository

import fittibackendapp.domain.diet.entity.Nutrition
import org.springframework.data.jpa.repository.JpaRepository

interface NutritionRepository: JpaRepository<Nutrition, Long>
