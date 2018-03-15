package pl.kerrex.trainingcenterbackend.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import pl.kerrex.trainingcenterbackend.domain.Exercise

@Configuration
class DefaultRepositoryConfiguration : RepositoryRestConfigurerAdapter() {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?) {
        config?.exposeIdsFor(Exercise::class.java)
    }
}