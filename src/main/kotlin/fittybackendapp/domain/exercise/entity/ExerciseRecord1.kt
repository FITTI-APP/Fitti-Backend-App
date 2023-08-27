package fittybackendapp.domain.exercise.entity

import fittybackendapp.common.entitiybase.AuditLoggingBase
import fittybackendapp.domain.auth.entity.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(name = "exercise_record_1")
class ExerciseRecord1(
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,
    @NotNull
    @Column(name = "start_time", nullable = false)
    var startTime: Instant,
    @NotNull
    @Column(name = "end_time", nullable = false)
    var endTime: Instant,
    @Size(max = 255)
    @NotNull
    @Column(name = "memo", nullable = false)
    var memo: String
): AuditLoggingBase() {
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
