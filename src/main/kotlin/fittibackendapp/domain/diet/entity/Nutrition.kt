package fittibackendapp.domain.diet.entity

import fittibackendapp.common.entitiybase.AuditLoggingBase
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "nutrition")
class Nutrition(
    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    var name: String,
    @NotNull
    @Column(name = "protein", nullable = false)
    var protein: Double,
    @NotNull
    @Column(name = "fat", nullable = false)
    var fat: Double,
    @NotNull
    @Column(name = "carbohydrate", nullable = false)
    var carbohydrate: Double
): AuditLoggingBase() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
