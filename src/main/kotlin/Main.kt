package ru.netology


fun main() {
    println("Hello World!")
    val p = Post(
        0, 0, "Bob", "Hello Alice!",
        likes = Likes(),
        comments = Comments()
    )
    println(p)
}