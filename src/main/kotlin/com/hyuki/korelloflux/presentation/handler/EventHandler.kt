package com.hyuki.korelloflux.presentation.handler

import com.hyuki.korelloflux.domain.event.service.EventService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import reactor.kotlin.core.publisher.toMono

@Component
class EventHandler(
    private val eventService: EventService,
) {
    suspend fun getEventsByBoardId(serverRequest: ServerRequest): ServerResponse =
        ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(
            eventService.findByBoardIdOrderByCreatedDateDesc(
                serverRequest.pathVariable("id").toLong().toMono()))


    suspend fun saveBoardEvents(serverRequest: ServerRequest): ServerResponse {
//        val mono = serverRequest.awaitBody(RequestBoard::class)
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(mono)
        return ok().buildAndAwait()
    }
}