package com.example.board.dto

import org.springframework.util.ObjectUtils

data class PostReq(
    val author: String,
    val title: String,
    val content: String,
    val id: Long? = null,
    ) {
    fun isUpdate(): Boolean = !ObjectUtils.isEmpty(id)
}
