package fittybackendapp.domain.exercise.entity

import fittybackendapp.common.entitiybase.AuditLoggingEnumBase
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "exercise_kind")
class ExerciseKind(
    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    var name: String
): AuditLoggingEnumBase() {
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
