package pl.kerrex.trainingcenterbackend

import javassist.tools.web.BadHttpRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.web.bind.annotation.*
import pl.kerrex.trainingcenterbackend.domain.UserMeasurement
import pl.kerrex.trainingcenterbackend.repository.UserMeasurementRepository
import pl.kerrex.trainingcenterbackend.repository.UserRepository
import java.security.Principal
import javax.servlet.http.HttpServletRequest

@RestController
class MeasurementsController(private val userMeasurementRepository: UserMeasurementRepository, private val userRepository: UserRepository) {

    @RequestMapping("/currentUserMeasurements", method = [RequestMethod.GET], produces = ["application/json"])
    @Secured("STANDARD_USER")
    fun getCurrentUserMeasurements(): List<UserMeasurement> {
        val userName = SecurityContextHolder.getContext().authentication.name
        val currentUserMeasurements = userMeasurementRepository.findByUsername(userName)

        return currentUserMeasurements
    }

    @RequestMapping("/currentUserMeasurements/{measurementId}", method = [RequestMethod.GET], produces = ["application/json"])
    @Secured("STANDARD_USER")
    fun getCurrentUserMeasurement(@PathVariable(value = "measurementId") measurementId: Long,
                                  user: Principal): UserMeasurement {
        return userMeasurementRepository.findById(user.name, measurementId)
    }

    @RequestMapping("/currentUserMeasurements/{measurementId}", method = [RequestMethod.DELETE], produces = ["application/json"])
    @Secured("STANDARD_USER")
    fun deleteCurrentUserMeasurement(@PathVariable(value = "measurementId") measurementId: Long,
                                     user: Principal): ResponseEntity<Map<String, String>> {
        val measurements = userMeasurementRepository.findByUsername(user.name)
        val foundMeasurement = measurements.find { it.id == measurementId }
                ?: return ResponseEntity(mapOf("status" to "ERROR"), HttpStatus.BAD_REQUEST)

        userMeasurementRepository.delete(foundMeasurement)
        return ResponseEntity.ok(mapOf("status" to "OK"))
    }

    @RequestMapping("/currentUserMeasurements", method = [RequestMethod.POST], produces = ["application/json"])
    @Secured("STANDARD_USER")
    fun saveCurrentUserMeasurement(@RequestBody measurement: UserMeasurement, user: Principal): UserMeasurement {
        val currentUser = userRepository.findByUsername(user.name)
        if (measurement.id == null) {
            measurement.user = currentUser
        } else {
            val currentMeasurement = userMeasurementRepository.findById(measurement.id!!)
            if (currentMeasurement.user!!.username != user.name) {
                throw BadHttpRequest()
            }
        }
        return userMeasurementRepository.save(measurement)
        
    }
}