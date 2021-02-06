package com.hyuki.korelloflux.presentation.router

import com.hyuki.korelloflux.presentation.handler.EventHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.parseMediaType
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono

@Configuration
class BoardRouter(
    private val eventHandler: EventHandler
) {

    @Bean
    fun boardRoutes(): RouterFunction<ServerResponse> {
        return coRouter {
            accept(APPLICATION_JSON).nest {
                GET("/api/v1/events/board/{id}", eventHandler::getEventsByBoardId)
                POST("/api/v1/events/board", eventHandler::saveBoardEvents)
            }
            accepted().contentType(parseMediaType("application/json;charset=UTF-8"))
        }
    }
}