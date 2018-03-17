package pl.kerrex.trainingcenterbackend.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import pl.kerrex.trainingcenterbackend.domain.Exercise
import pl.kerrex.trainingcenterbackend.domain.TrainingPlan

@Configuration
open class DefaultRepositoryConfiguration : RepositoryRestConfigurerAdapter() {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?) {
        config?.exposeIdsFor(Exercise::class.java, TrainingPlan::class.java)
    }
}