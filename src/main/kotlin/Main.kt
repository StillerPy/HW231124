package ru.netology

import Attachments
import Audio
import AudioAttachment
import Post
import Video
import VideoAttachment




fun main0() {
    val attachments = Attachments()
    attachments.add(AudioAttachment(0, Audio("Rammstein - Sonne", 151.6)))
    val p = Post(
        0, 0, "Bob", "I love this song!",
        likes = Likes(),
        comments = Comments(),
        attachments = attachments
    )
    p.print()
}
fun main() {
    open class Parent
    class Child : Parent()
    class GenPair<A, B>(val a: A, val b: B) {
        override fun toString(): String = "<$a, $b>"
    }
    val children = GenPair(Child(), Child())
    val parents: GenPair<out Parent, out Parent> = children
    println(parents)

}