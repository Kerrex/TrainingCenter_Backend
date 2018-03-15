package pl.kerrex.trainingcenterbackend.Service

import pl.kerrex.trainingcenterbackend.domain.User
import pl.kerrex.trainingcenterbackend.dto.UserDTO

interface UserService {
    fun findByUsernameOrEmail(username: String): User?

    fun findAllUsers(): List<User>

    fun registerNewUser(newUser: UserDTO)
}