package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.repository.CrudRepository
import pl.kerrex.trainingcenterbackend.domain.User
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(path = "/users")
interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): User?

    fun findByEmail(email: String): User?
}