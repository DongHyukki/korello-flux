package com.hyuki.korelloflux.presentation.processor

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

interface KorelloProcessor {

    companion object {
        const val INPUT = "korello"
    }

    @Input(INPUT)
    fun korello(): SubscribableChannel

}