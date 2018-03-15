package pl.kerrex.trainingcenterbackend.domain

import javax.persistence.*

@Entity
@Table(name = "user_data")
class UserData {

    @Id
    var user_id: Long? = null

    var height: Int? = null

    var gender: Int? = null
}