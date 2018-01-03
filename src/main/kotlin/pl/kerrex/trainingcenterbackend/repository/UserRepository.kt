package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.repository.CrudRepository
import pl.kerrex.trainingcenterbackend.domain.User


interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): User
}