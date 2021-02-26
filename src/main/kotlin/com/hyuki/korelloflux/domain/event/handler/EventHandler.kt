package com.hyuki.korelloflux.domain.event.handler

import com.hyuki.korelloflux.domain.event.service.EventService
import kotlinx.coroutines.flow.toList
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
        ok().bodyValueAndAwait(
            eventService.findByTypeIdAndSelectTypeOrderByCreatedDateDesc(
                serverRequest.pathVariable("id").toMono(),
                "board".toMono()
            ).toList())

    suspend fun getEventsByCardId(serverRequest: ServerRequest): ServerResponse =
        ok().bodyValueAndAwait(
            eventService.findByTypeIdAndSelectTypeOrderByCreatedDateDesc(
                serverRequest.pathVariable("id").toMono(),
                "card".toMono()
            ).toList())

    suspend fun saveBoardEvents(serverRequest: ServerRequest): ServerResponse {
        return ok().buildAndAwait()
    }
}