package fittybackendapp.common.entitiybase

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditLoggingBase {
    @CreatedBy
    @NotNull
    @Column(name = "created_by")
    var createdBy: Long = 0

    @CreatedDate
    @NotNull
    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime

    @LastModifiedBy
    @NotNull
    @Column(name = "updated_by")
    var updatedBy: Long = 0

    @LastModifiedDate
    @NotNull
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime
}
