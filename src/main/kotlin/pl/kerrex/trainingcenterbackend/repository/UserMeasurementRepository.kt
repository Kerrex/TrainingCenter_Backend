package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import pl.kerrex.trainingcenterbackend.domain.UserMeasurement

@RepositoryRestResource(path = "/measurements")
interface UserMeasurementRepository : PagingAndSortingRepository<UserMeasurement, Long> {
    fun findById(userId: Long): UserMeasurement

    @Query("SELECT m FROM UserMeasurement m JOIN m.user u WHERE u.username = :username")
    fun findByUsername(@Param("username") username: String): List<UserMeasurement>

    @Query("SELECT m FROM UserMeasurement m JOIN m.user u where u.username = :username and m.id = :id")
    fun findById(@Param("username") username: String, @Param("id") id: Long): UserMeasurement
}