package pl.kerrex.trainingcenterbackend.Service

import pl.kerrex.trainingcenterbackend.domain.RandomCity
import pl.kerrex.trainingcenterbackend.domain.User


interface GenericService {
    fun findByUsername(username: String): User

    fun findAllUsers(): List<User>

    fun findAllRandomCities(): List<RandomCity>
}