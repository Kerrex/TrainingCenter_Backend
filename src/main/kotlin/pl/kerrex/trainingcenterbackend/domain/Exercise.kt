package pl.kerrex.trainingcenterbackend.domain

import org.codehaus.jackson.annotate.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "exercise")
class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "default_name")
    var defaultName: String? = null

    @Column(name = "youtube_link")
    var youtubeLink: String? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exerciseLanguageVersionPk.exercise")
    var exerciseLanguageVersions: MutableList<ExerciseLanguageVersion>? = null

    @JsonProperty
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exerciseTrainingPlanPk.exercise")
    var exerciseTrainingPlan: MutableList<ExerciseTrainingPlan>? = null
}