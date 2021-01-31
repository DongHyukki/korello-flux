package com.hyuki.korelloflux.presentation.router

import com.hyuki.korelloflux.presentation.handler.BoardHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.*

@Configuration
class BoardRouter(
    private val boardHandler: BoardHandler
) {

    @Bean
    fun boardRoutes(): RouterFunction<ServerResponse> {
        return coRouter {
            accept(APPLICATION_JSON).nest {
                GET("/api/v1/events/board/{id}", boardHandler::getEventsByBoardId)
                POST("/api/v1/events/board", boardHandler::saveBoardEvents)
            }
        }
    }
}

data class RequestBoard(
    val id: Long,
    val title: String
)