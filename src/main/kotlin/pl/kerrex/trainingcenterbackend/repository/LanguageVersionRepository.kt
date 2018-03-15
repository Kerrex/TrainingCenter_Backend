package pl.kerrex.trainingcenterbackend.repository

import org.springframework.data.repository.PagingAndSortingRepository
import pl.kerrex.trainingcenterbackend.domain.LanguageVersion

interface LanguageVersionRepository : PagingAndSortingRepository<LanguageVersion, String> {

}