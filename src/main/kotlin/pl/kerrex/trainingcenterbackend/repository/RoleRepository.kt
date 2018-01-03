package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.repository.CrudRepository
import pl.kerrex.trainingcenterbackend.domain.Role


interface RoleRepository : CrudRepository<Role, Long>