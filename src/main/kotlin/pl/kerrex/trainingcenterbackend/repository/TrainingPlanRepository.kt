package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import pl.kerrex.trainingcenterbackend.domain.TrainingPlan

@RepositoryRestResource(path = "/training_plans")
interface TrainingPlanRepository : PagingAndSortingRepository<TrainingPlan, Long> {
    @Query("SELECT t FROM TrainingPlan t JOIN t.user u WHERE u.username = ?#{principal}") //
    override fun findAll(pageable: Pageable?): Page<TrainingPlan>?

}