package pl.kerrex.trainingcenterbackend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


@Entity
@Table(name = "training_center_user")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "username")
    var username: String? = null

    @Column(name = "password")
    @JsonIgnore
    var password: String? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "email")
    var email: String? = null

    /**
     * Roles are being eagerly loaded here because
     * they are a fairly small collection of items for this example.
     */
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = [(JoinColumn(name = "user_id", referencedColumnName = "id"))], inverseJoinColumns = [(JoinColumn(name = "role_id", referencedColumnName = "id"))])
    var roles: MutableList<Role>? = null

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    var measurements: MutableList<UserMeasurement>? = null

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    var userData: UserData? = null
}