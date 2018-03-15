package pl.kerrex.trainingcenterbackend.Service.Impl

import org.springframework.stereotype.Service
import pl.kerrex.trainingcenterbackend.repository.UserRepository
import pl.kerrex.trainingcenterbackend.Service.GenericService
import pl.kerrex.trainingcenterbackend.domain.User


@Service
class GenericServiceImpl(private val userRepository: UserRepository) : GenericService {

    override fun findByUsernameOrEmail(username: String): User? {
        val userByEmail = userRepository.findByEmail(username)
        return userRepository.findByUsername(username) ?: userByEmail
    }

    override fun findAllUsers(): List<User> {
        return userRepository!!.findAll() as List<User>
    }

}