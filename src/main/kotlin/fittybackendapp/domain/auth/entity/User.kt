package fittybackendapp.domain.auth.entity

import fittybackendapp.common.entitiybase.AuditLoggingBase
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
import jakarta.validation.constraints.Size

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    @field:Size(max = 255)
    @field:NotNull
    @Column(name = "name", nullable = false)
    var name: String,

    @field:Size(max = 255)
    @field:NotNull
    @Column(name = "email", nullable = false)
    var email: String,

    @field:Size(max = 255)
    @field:NotNull
    @Column(name = "password", nullable = false)
    var password: String,
    
    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role", nullable = false)
    var role: Role
): AuditLoggingBase()
