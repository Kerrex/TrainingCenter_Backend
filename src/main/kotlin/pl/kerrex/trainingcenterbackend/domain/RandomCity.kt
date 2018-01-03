package pl.kerrex.trainingcenterbackend.domain

import javax.persistence.*


@Entity
@Table(name = "random_city")
class RandomCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null
}