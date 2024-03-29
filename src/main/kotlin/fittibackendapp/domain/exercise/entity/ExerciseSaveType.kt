package fittibackendapp.domain.exercise.entity

import fittibackendapp.common.entitiybase.AuditLoggingEnumBase
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "exercise_save_type")
class ExerciseSaveType(
    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    var name: String,
): AuditLoggingEnumBase() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
