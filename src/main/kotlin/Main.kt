package ru.netology

import Post
import VideoAttachment

fun printPosts() {

}


fun main() {
    println("Hello World!")
    val p = Post(
        0, 0, "Bob", "Hello Alice!",
        likes = Likes(),
        comments = Comments(),
        attachments = arrayOf(VideoAttachment(0, "Rammstein, Sonne", 151.6))
    )
    p.print()
}