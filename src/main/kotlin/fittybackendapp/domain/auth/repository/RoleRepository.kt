package fittybackendapp.domain.auth.repository

import fittybackendapp.domain.auth.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository: JpaRepository<Role, Long> {
    fun findByName(name: String): Role?
}
