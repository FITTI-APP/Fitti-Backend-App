package fittibackendapp.domain.diet.repository

import fittibackendapp.domain.diet.entity.Diet
import org.springframework.data.jpa.repository.JpaRepository

interface DietRepository : JpaRepository<Diet, Long>
