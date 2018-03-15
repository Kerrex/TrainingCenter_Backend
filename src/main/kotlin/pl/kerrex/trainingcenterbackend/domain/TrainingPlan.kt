package pl.kerrex.trainingcenterbackend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "training_plan")
class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainingPlan")
    var trainingPlanDates: MutableList<TrainingPlanDate>? = null

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null
}