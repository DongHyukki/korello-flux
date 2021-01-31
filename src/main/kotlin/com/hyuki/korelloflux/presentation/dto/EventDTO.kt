package com.hyuki.korelloflux.presentation.dto

import com.hyuki.korelloflux.presentation.dto.type.KorelloActionType
import com.hyuki.korelloflux.presentation.dto.type.KorelloEventType

//data class EventDTO(
//    val id: Long,
//    val type: String,
//    val action: String,
//    val memberId: Long,
//    val memberName: String,
//    val message: String,
//)

data class EventDTO(
    val id: Long,
    val type: KorelloEventType,
    val action: KorelloActionType,
    val memberId: Long?,
    val memberName: String?,
    val message: String?,
)