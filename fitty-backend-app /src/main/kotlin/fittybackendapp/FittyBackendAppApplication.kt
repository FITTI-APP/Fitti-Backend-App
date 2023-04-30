package fittybackendapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FittyBackendAppApplication

fun main(args: Array<String>) {
	runApplication<FittyBackendAppApplication>(*args)
}
