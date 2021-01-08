package com.hyuki.korelloflux.presentation.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class BoardRouter {

    @Bean
    fun boardRoutes(): RouterFunction<ServerResponse> {
        return coRouter {
            GET("/api/v1/events/board/{id}") { serverRequest ->
                val boardId = serverRequest.pathVariable("id").toLong()

                ok().bodyValueAndAwait(boardId)
            }
        }
    }


}