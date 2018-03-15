package pl.kerrex.trainingcenterbackend.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "exercise_language_version")
class ExerciseLanguageVersion {

    @EmbeddedId
    var exerciseLanguageVersionPk: ExerciseLanguageVersionPK? = null

    @Column
    var name: String? = null

    @JsonProperty("languageVersionCode")
    fun languageVersionCode(): String {
        return exerciseLanguageVersionPk!!.languageVersion!!.code!!
    }

    @Embeddable
    class ExerciseLanguageVersionPK : Serializable {
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "exercise_id")
        var exercise: Exercise? = null

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "language_version_code")
        var languageVersion: LanguageVersion? = null
    }
}