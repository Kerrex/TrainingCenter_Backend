package pl.kerrex.trainingcenterbackend.Service

import pl.kerrex.trainingcenterbackend.domain.User


interface GenericService {
    fun findByUsernameOrEmail(username: String): User?

    fun findAllUsers(): List<User>
}