package pl.kerrex.trainingcenterbackend.domain

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "training_plan_date")
class TrainingPlanDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var date: Date? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_plan_id")
    var trainingPlan: TrainingPlan? = null
}