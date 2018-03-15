package pl.kerrex.trainingcenterbackend.Service

import org.springframework.security.provisioning.UserDetailsManager
import pl.kerrex.trainingcenterbackend.domain.User
import pl.kerrex.trainingcenterbackend.dto.UserDTO

interface CustomUserDetailsManager: UserDetailsManager {
    fun createUser(user: UserDTO)
}