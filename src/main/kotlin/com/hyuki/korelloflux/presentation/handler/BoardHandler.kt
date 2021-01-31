package com.hyuki.korelloflux.presentation.handler

import com.hyuki.korelloflux.presentation.router.RequestBoard
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class BoardHandler {

    suspend fun getEventsByBoardId(serverRequest: ServerRequest) = ServerResponse.ok().bodyValueAndAwait(serverRequest.pathVariable("id").toLong())

    suspend fun saveBoardEvents(serverRequest: ServerRequest): ServerResponse {
//        val mono = serverRequest.awaitBody(RequestBoard::class)
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(mono)
        return ServerResponse.ok().buildAndAwait()
    }
}