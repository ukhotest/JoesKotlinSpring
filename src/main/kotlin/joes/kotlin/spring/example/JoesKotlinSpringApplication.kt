package joes.kotlin.spring.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JoesKotlinSpringApplication

fun main(args: Array<String>) {
    runApplication<SpringRestSeedApplication>(*args)
}
