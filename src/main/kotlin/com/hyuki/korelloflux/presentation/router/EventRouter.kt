package com.hyuki.korelloflux.presentation.router

import com.hyuki.korelloflux.domain.event.handler.EventHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.parseMediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class BoardRouter(
    private val eventHandler: EventHandler
) {

    @Bean
    fun boardRoutes(): RouterFunction<ServerResponse> {
        return coRouter {
            accept(APPLICATION_JSON).nest {
                GET("/api/v2/events/board/{id}", eventHandler::getEventsByBoardId)
                GET("/api/v2/events/card/{id}", eventHandler::getEventsByCardId)
                POST("/api/v2/events/board", eventHandler::saveBoardEvents)
            }
            accepted().contentType(parseMediaType("application/json;charset=UTF-8"))
        }
    }
}