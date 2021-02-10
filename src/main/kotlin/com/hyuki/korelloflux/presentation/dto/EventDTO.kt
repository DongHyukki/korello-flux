package com.hyuki.korelloflux.presentation.dto

import com.hyuki.korelloflux.domain.event.model.Event
import com.hyuki.korelloflux.presentation.dto.type.KorelloActionType
import com.hyuki.korelloflux.presentation.dto.type.KorelloEventType
import com.hyuki.korelloflux.presentation.dto.type.KorelloSelectType

data class EventDTO(
    val typeId: Long,
    val selectType: KorelloSelectType,
    val eventType: KorelloEventType,
    val action: KorelloActionType,
    val memberId: Long,
    val memberName: String,
    val message: String,
) {
    fun toEntity(): Event {
        return Event(typeId.toString(), selectType.eng_name, eventType.eng_name, action.eng_name, memberId, memberName, message)
    }
}