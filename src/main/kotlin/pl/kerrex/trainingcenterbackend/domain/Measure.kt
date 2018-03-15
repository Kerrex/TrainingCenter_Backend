package pl.kerrex.trainingcenterbackend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "measure")
class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "measure")
    var exerciseTrainingPlans: MutableList<ExerciseTrainingPlan>? = null
}