package pl.kerrex.trainingcenterbackend.domain

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "exercise_training_plan")
class ExerciseTrainingPlan {

    @EmbeddedId
    var exerciseTrainingPlanPk: ExerciseTrainingPlanPK? = null

    @Column(name = "series_count")
    var seriesCount: Int? = null

    var intensivity: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measure_id")
    var measure: Measure? = null

    @Embeddable
    class ExerciseTrainingPlanPK : Serializable {
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "exercise_id")
        var exercise: Exercise? = null

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "training_plan_id")
        var trainingPlan: TrainingPlan? = null
    }
}