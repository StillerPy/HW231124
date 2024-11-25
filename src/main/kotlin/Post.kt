package ru.netology


data class Post(
    val id: Int = 0,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val likes: Likes,
    val comments: Comments)