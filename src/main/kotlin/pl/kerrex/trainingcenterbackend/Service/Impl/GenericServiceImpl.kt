package pl.kerrex.trainingcenterbackend.Service.Impl

import pl.kerrex.trainingcenterbackend.domain.RandomCity
import pl.kerrex.trainingcenterbackend.repository.RandomCityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pl.kerrex.trainingcenterbackend.repository.UserRepository
import pl.kerrex.trainingcenterbackend.Service.GenericService
import pl.kerrex.trainingcenterbackend.domain.User


@Service
class GenericServiceImpl(private val userRepository: UserRepository,
                         private val randomCityRepository: RandomCityRepository) : GenericService {

    override fun findByUsername(username: String): User {
        return userRepository!!.findByUsername(username)
    }

    override fun findAllUsers(): List<User> {
        return userRepository!!.findAll() as List<User>
    }

    override fun findAllRandomCities(): List<RandomCity> {
        return randomCityRepository!!.findAll() as List<RandomCity>
    }
}