package fittibackendapp.domain.auth.repository

import fittibackendapp.domain.auth.entity.LoginType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LoginTypeRepository: JpaRepository<LoginType, Long> {
    fun findByName(name: String): LoginType?
}
