package com.hyuki.korelloflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
class KorelloFluxApplication

fun main(args: Array<String>) {
    runApplication<KorelloFluxApplication>(*args)
}
