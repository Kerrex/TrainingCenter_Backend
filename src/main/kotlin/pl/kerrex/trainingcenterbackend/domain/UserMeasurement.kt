package pl.kerrex.trainingcenterbackend.domain

import org.codehaus.jackson.annotate.JsonIgnore
import java.sql.Timestamp
import javax.persistence.*


@Entity
@Table(name = "user_measurement")
class UserMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "waist")
    var waist: Long? = null

    @Column(name = "weight")
    var weight: Long? = null

    @Column
    var biceps: Long? = null

    @Column
    var thigh: Long? = null

    @Column
    var chest: Long? = null

    @Column
    var neck: Long? = null

    @Column
    var hips: Long? = null

    @Column(name = "date_added")
    var dateAdded: Timestamp? = null

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null

}