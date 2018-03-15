package pl.kerrex.trainingcenterbackend.Service.Impl

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import pl.kerrex.trainingcenterbackend.Service.CustomUserDetailsManager
import pl.kerrex.trainingcenterbackend.Service.UserService
import pl.kerrex.trainingcenterbackend.domain.User
import pl.kerrex.trainingcenterbackend.dto.UserDTO
import pl.kerrex.trainingcenterbackend.repository.UserRepository

@Service
class UserServiceImpl(private val userRepository: UserRepository,
                      private val userDetailsManager: CustomUserDetailsManager) : UserService {

    override fun findByUsernameOrEmail(username: String): User? {
        val userByEmail = userRepository.findByEmail(username)
        return userRepository.findByUsername(username) ?: userByEmail
    }

    override fun findAllUsers(): List<User> {
        return userRepository.findAll() as List<User>
    }

    override fun registerNewUser(newUser: UserDTO) {
        userDetailsManager.createUser(newUser)
    }

}