package fittibackendapp.domain.exercise.entity

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
import jakarta.validation.constraints.Size
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.LocalTime

@Entity
@Table(name = "exercise_set_record")
class ExerciseSetRecord(
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_exercise_record_id", nullable = false)
    var exerciseExerciseRecord: ExerciseExerciseRecord,
    @NotNull
    @Column(name = "`order`", nullable = false)
    var order: Int,
    @Column(name = "weight")
    var weight: Double,
    @Column(name = "reps")
    var reps: Int,
    @Column(name = "total_time")
    var totalTime: LocalTime,
    @Size(max = 255)
    @NotNull
    @Column(name = "memo", nullable = false)
    var memo: String,
    @Column(name = "distance")
    var distance: Double
): AuditLoggingBase() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
