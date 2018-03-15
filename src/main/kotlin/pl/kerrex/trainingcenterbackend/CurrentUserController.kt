package pl.kerrex.trainingcenterbackend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import pl.kerrex.trainingcenterbackend.Service.UserService
import pl.kerrex.trainingcenterbackend.domain.User
import java.security.Principal

@RestController
class CurrentUserController(private val userService: UserService) {

    @GetMapping("/currentUserData", produces = ["application/json"])
    fun currentUser(user: Principal) : User? {
        return userService.findByUsernameOrEmail(user.name)
    }

}