package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.security.access.annotation.Secured
import pl.kerrex.trainingcenterbackend.domain.Exercise

@RepositoryRestResource(path = "/exercises")
interface ExerciseRepository : PagingAndSortingRepository<Exercise, Long> {

    @Secured("ADMIN_USER")
    override fun findAll(pageable: Pageable?): Page<Exercise>

    @Secured("ADMIN_USER")
    override fun findOne(id: Long?): Exercise

    @Query("SELECT e FROM Exercise e " +
            "JOIN e.exerciseTrainingPlan etp " +
            "JOIN etp.exerciseTrainingPlanPk.trainingPlan tp " +
            "JOIN tp.user u " +
            "WHERE tp.id = :trainingPlanId AND u.username = ?#{principal}")
    fun findByTrainingPlanId(@Param("trainingPlanId") trainingPlanId: Long?, pageable: Pageable?): Page<Exercise>
}