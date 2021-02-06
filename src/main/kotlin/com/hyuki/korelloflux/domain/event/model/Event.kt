package com.hyuki.korelloflux.domain.event.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "event")
class Event(
    @Indexed
    val boardId: String,
    @Indexed
    val type: String,
    val action: String,
    val memberId: Long,
    val memberName: String,
    val message: String
) {
    @Id
    lateinit var id: String
    @CreatedDate
    lateinit var createdDate: LocalDateTime
    @LastModifiedDate
    lateinit var lastModifiedDate: LocalDateTime
}
