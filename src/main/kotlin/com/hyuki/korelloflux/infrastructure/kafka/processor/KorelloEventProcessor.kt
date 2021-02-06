package com.hyuki.korelloflux.infrastructure.kafka.processor

import com.hyuki.korelloflux.domain.event.service.EventService
import com.hyuki.korelloflux.presentation.dto.EventDTO
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.messaging.handler.annotation.Payload
import reactor.kotlin.core.publisher.toMono

@EnableBinding(KorelloProcessor::class)
class KorelloEventProcessor(
    private val eventService: EventService
) {

    @StreamListener(value = KorelloProcessor.INPUT)
    fun handler(@Payload payload: EventDTO) {
        eventService.saveEvent(payload.toEntity()).log().subscribe()
    }
}