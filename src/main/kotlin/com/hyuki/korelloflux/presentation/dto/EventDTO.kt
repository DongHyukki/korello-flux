package com.hyuki.korelloflux.presentation.dto

import com.hyuki.korelloflux.domain.event.model.Event
import com.hyuki.korelloflux.presentation.dto.type.KorelloActionType
import com.hyuki.korelloflux.presentation.dto.type.KorelloEventType

data class EventDTO(
    val id: Long,
    val type: KorelloEventType,
    val action: KorelloActionType,
    val memberId: Long,
    val memberName: String,
    val message: String,
) {
    fun toEntity(): Event {
        return Event(id.toString(), type.eng_name, action.eng_name, memberId, memberName, message)
    }
}