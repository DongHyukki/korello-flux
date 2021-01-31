package com.hyuki.korelloflux.presentation.dto.type

import java.io.Serializable

enum class KorelloEventType(
    val eng_name: String,
    var kor_name: String
) {
    BOARD("board", "보드"),
    CARD("card", "카드"),
    MEMBER("member", "멤버"),
    LABEL("label", "라벨"),
    TODO("todo", "할일");

    companion object {
        private val ulList = listOf(LABEL, TODO)
        private val ulPostposition = "을"
        private val leulPostposition = "를"
    }

    fun addPostposition() {
        if(ulList.contains(this)) {
            this.kor_name += ulPostposition
        } else {
            this.kor_name += leulPostposition
        }
    }


}