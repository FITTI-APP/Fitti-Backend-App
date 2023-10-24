package fittibackendapp.common.entitiybase

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditLoggingEnumBase {
    @LastModifiedDate
    @NotNull
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime

    @CreatedDate
    @NotNull
    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime
}
