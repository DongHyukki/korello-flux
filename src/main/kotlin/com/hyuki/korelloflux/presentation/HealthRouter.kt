package com.hyuki.korelloflux.presentation

import kotlinx.coroutines.runBlocking
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class HealthRouter {

    @Bean
    fun healthRoutes(): RouterFunction<ServerResponse> {
        return coRouter {
          GET("/health_check.html") {
              ok().buildAndAwait()
          }
        }
    }

}