package pl.kerrex.trainingcenterbackend

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.beans.factory.annotation.Autowired
import pl.kerrex.trainingcenterbackend.Service.GenericService
import pl.kerrex.trainingcenterbackend.domain.User


@RestController
@RequestMapping("/springjwt")
class ResourceController {
    @Autowired
    private val userService: GenericService? = null

    val users: List<User>
        @RequestMapping(value = ["/users"], method = arrayOf(RequestMethod.GET))
        @PreAuthorize("hasAuthority('ADMIN_USER')")
        get() = userService!!.findAllUsers()
}