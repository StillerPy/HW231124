package ru.netology

data class Comment(
    val id: Int = 0,
    val authorId: Int = 0,
    val authorName: String = "==Comment Author Name==",
    val content: String = "==Comment content==",
    val likes: Likes = Likes()
    )

class Comments {
    val list = mutableListOf<Comment>()
    fun print() {
        println(list)
    }
}