package pl.kerrex.trainingcenterbackend.domain

import javax.persistence.*


@Entity
@Table(name = "app_role")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "role_name")
    var roleName: String? = null

    @Column(name = "description")
    var description: String? = null

}