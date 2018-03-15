package pl.kerrex.trainingcenterbackend.domain

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
}