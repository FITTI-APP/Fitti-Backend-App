package fittibackendapp.domain.diet.entity;

import fittibackendapp.common.entitiybase.AuditLoggingBase
import fittibackendapp.domain.auth.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "target_pcf_ratio")

class TargetPcfRatio(
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,
    @NotNull
    @Column(name = "protein", nullable = false)
    var protein: Double,
    @NotNull
    @Column(name = "carbohydrate", nullable = false)
    var carbohydrate: Double,
    @NotNull
    @Column(name = "fat", nullable = false)
    var fat: Double
): AuditLoggingBase() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
