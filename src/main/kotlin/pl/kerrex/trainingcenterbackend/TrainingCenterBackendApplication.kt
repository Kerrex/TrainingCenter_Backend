package pl.kerrex.trainingcenterbackend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class TrainingCenterBackendApplication

fun main(args: Array<String>) {
    SpringApplication.run(TrainingCenterBackendApplication::class.java, *args)
}
