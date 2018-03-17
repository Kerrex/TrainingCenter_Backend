package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import pl.kerrex.trainingcenterbackend.domain.ExerciseTrainingPlan

@RepositoryRestResource(path = "/exercise_training_plans")
interface ExerciseTrainingPlanRepository : PagingAndSortingRepository<ExerciseTrainingPlan, ExerciseTrainingPlan.ExerciseTrainingPlanPK> {

    @Query("SELECT etp From ExerciseTrainingPlan etp " +
            "WHERE etp.exerciseTrainingPlanPk.trainingPlan.id = :trainingPlanId " +
                "AND etp.exerciseTrainingPlanPk.exercise.id = :exerciseId")
    fun findByTrainingPlanIdAndExerciseId(@Param("trainingPlanId") trainingPlanId: Long?,
                                          @Param("exerciseId") exerciseId: Long?)
}