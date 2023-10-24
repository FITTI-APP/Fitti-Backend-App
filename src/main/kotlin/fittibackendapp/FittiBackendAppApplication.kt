package fittibackendapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FittiBackendAppApplication

fun main(args: Array<String>) {
    runApplication<FittiBackendAppApplication>(*args)
}
