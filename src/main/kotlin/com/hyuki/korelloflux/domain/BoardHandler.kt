package com.hyuki.korelloflux.domain

import com.hyuki.korelloflux.presentation.router.RequestBoard
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class BoardHandler {

    suspend fun getEventsByBoardId(serverRequest: ServerRequest) = ServerResponse.ok().bodyValueAndAwait(serverRequest.pathVariable("id").toLong())
    suspend fun saveBoardEvents(serverRequest: ServerRequest): ServerResponse {
        val mono = serverRequest.awaitBody(RequestBoard::class)
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(mono)
    }
}