package fittibackendapp.domain.diet.repository

import fittibackendapp.domain.diet.entity.TargetPcfRatio
import org.springframework.data.jpa.repository.JpaRepository

interface TargetPcfRatioRepository : JpaRepository<TargetPcfRatio, Long> {
    fun findByUserId(userId: Long): TargetPcfRatio
}
