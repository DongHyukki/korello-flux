package com.hyuki.korelloflux.domain.event.service

import com.hyuki.korelloflux.domain.event.model.Event
import com.hyuki.korelloflux.domain.event.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class EventService(
    private val eventRepository: EventRepository
) {

    suspend fun findByBoardIdOrderByCreatedDateDesc(typeId: Mono<String>, selectType: Mono<String>): Flow<Event> {
        return eventRepository.findByTypeIdAndSelectTypeOrderByCreatedDateDesc(typeId, selectType)
    }

    fun saveEvent(event: Event): Mono<Event> {
        return eventRepository.save(event)
    }
}