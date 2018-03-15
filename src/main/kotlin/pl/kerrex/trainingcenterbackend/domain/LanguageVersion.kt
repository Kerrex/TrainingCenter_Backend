package pl.kerrex.trainingcenterbackend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "language_version")
class LanguageVersion {

    @Id
    var code: String? = null

    @Column
    var name: String? = null


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exerciseLanguageVersionPk.exercise")
    var exerciseLanguageVersions: MutableList<ExerciseLanguageVersion>? = null
}