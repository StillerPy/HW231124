package ru.netology

import Attachments

data class Comment(
    val id: Int = 0,
    val fromId: Int = 0,
    val text: String = "==Comment text==",
    val likes: Likes = Likes(),
    val date: Long = 0,
    val replyToUserId: Int? = null,
    val replyToCommentId: Int? = null,
    val isDonat: Boolean = false,
    val attachments: Attachments? = null,
    var isReported: Boolean = false
    )

class Comments {
    val list = mutableListOf<Comment>()
    fun print() {
        println(list)
    }
    fun add(comment: Comment) {
        list.add(comment)
    }
}