package fittibackendapp.domain.auth.entity

import fittibackendapp.common.entitiybase.AuditLoggingBase
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "user_detail")
class UserDetail(
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,
    @NotNull
    @Column(name = "age", nullable = false)
    var age: Int,
    @NotNull
    @Column(name = "height", nullable = false)
    var height: Double,
    @NotNull
    @Column(name = "weight", nullable = false)
    var weight: Double,
    @NotNull
    @Column(name = "muscle_mass", nullable = false)
    var muscleMass: Double,
    @NotNull
    @Column(name = "body_fat", nullable = false)
    var bodyFat: Double,
    @NotNull
    @Column(name = "target_weight", nullable = false)
    var targetWeight: Double,
    @NotNull
    @Column(name = "target_muscle_mass", nullable = false)
    var targetMuscleMass: Double
): AuditLoggingBase() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
