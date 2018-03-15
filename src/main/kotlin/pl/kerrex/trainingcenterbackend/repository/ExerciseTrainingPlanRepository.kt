package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import pl.kerrex.trainingcenterbackend.domain.ExerciseTrainingPlan

@RepositoryRestResource(path = "/exercise_training_plans")
interface ExerciseTrainingPlanRepository : PagingAndSortingRepository<ExerciseTrainingPlan, ExerciseTrainingPlan.ExerciseTrainingPlanPK> {

/*    @RestResource(path = "/by_training_plan")
    @Query("SELECT etp FROM ExerciseTrainingPlan etp " +
            "JOIN etp.trainingPlan tp " +
            "JOIN tp.user u " +
                "WHERE u.username = ?#{principal} AND tp.id = :trainingPlanId")
    fun findByTrainingPlanId(@Param("trainingPlanId") trainingPlanId: Long)*/
}