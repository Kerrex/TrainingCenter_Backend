package pl.kerrex.trainingcenterbackend

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import pl.kerrex.trainingcenterbackend.Service.UserService
import pl.kerrex.trainingcenterbackend.dto.UserDTO

@RestController
class RegisterController(private val userService: UserService) {

    @RequestMapping("/register", method = [(RequestMethod.POST)], produces = ["application/json"])
    fun register(@RequestBody userDTO: UserDTO): Map<String, String> {
        val errorList = mutableListOf<String>()
        val email = userDTO.email
        if (email.isNullOrBlank()) {
            errorList.add("noEmail")
        }

        if (email?.contains("@") == false) {
            errorList.add("emailFormat")
        }

        val username = userDTO.username
        if (username.isNullOrBlank()) {
            errorList.add("noUsername")
        }

        if (username?.contains("@") == true) {
            errorList.add("usernameFormat")
        }

        if (userDTO.password.isNullOrBlank()) {
            errorList.add("noPassword")
        }

        if (username != null && userService.findByUsernameOrEmail(username) != null) {
            errorList.add("usernameTaken")
        }

        if (email != null && userService.findByUsernameOrEmail(email) != null) {
            errorList.add("emailTaken")
        }

        return if (errorList.isNotEmpty()) {
            mapOf("errors" to errorList.joinToString(", "))
        } else {
            userService.registerNewUser(userDTO)
            mapOf("status" to "ok")
        }
    }

    @RequestMapping("/register/is_username_taken", method = [(RequestMethod.POST)], produces = ["application/json"])
    fun isUsernameTaken(@RequestBody usernameMap: Map<String, String>): Map<String, String> {
        val username = usernameMap["username"]
        val isUsernameTaken = userService.findByUsernameOrEmail(username!!) != null

        return mapOf("result" to isUsernameTaken.toString())

    }
}