package com.hyuki.korelloflux.domain.event.repository

import com.hyuki.korelloflux.domain.event.model.Event
import kotlinx.coroutines.flow.Flow
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface EventRepository : ReactiveMongoRepository<Event, Int> {
    fun findByTypeIdAndSelectTypeOrderByCreatedDateDesc(typeId: Mono<String>, selectType: Mono<String>): Flow<Event>
}