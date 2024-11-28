package ru.netology


data class Post(
    val id: Int = 0,
    val authorId: Int = 0,
    val authorName: String = "==Post Author==",
    val content: String = "==Post content==",
    val likes: Likes = Likes(),
    val comments: Comments = Comments())