package pl.kerrex.trainingcenterbackend.repository

import pl.kerrex.trainingcenterbackend.domain.RandomCity
import org.springframework.data.repository.CrudRepository


interface RandomCityRepository : CrudRepository<RandomCity, Long>