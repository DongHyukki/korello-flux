package com.hyuki.korelloflux.presentation.processor

import com.hyuki.korelloflux.presentation.dto.EventDTO
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.handler.annotation.Payload

@EnableBinding(KorelloProcessor::class)
class KorelloEventProcessor {

    @StreamListener(value = KorelloProcessor.INPUT)
    fun handler(@Payload payload: EventDTO) {
        payload.toString()
        payload.toString()
    }
}