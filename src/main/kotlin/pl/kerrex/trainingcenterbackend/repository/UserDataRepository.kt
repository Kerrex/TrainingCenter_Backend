package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.repository.CrudRepository
import pl.kerrex.trainingcenterbackend.domain.Role
import pl.kerrex.trainingcenterbackend.domain.UserData

interface UserDataRepository : CrudRepository<Role, Long> {
    fun findById(id: Int): UserData
}