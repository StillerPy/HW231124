import ru.netology.Comments
import ru.netology.Likes


data class Post(
    val id: Int = 0,
    val authorId: Int = 0,
    val authorName: String = "==Post Author Name==",
    val content: String = "==Post content==",
    val likes: Likes = Likes(),
    val attachments: Array<Attachment> = emptyArray(),
    val comments: Comments? = null) {
    fun print() {
        println("Post #$id by $authorName ($authorId)")
        println(content)
        if (attachments.isNotEmpty()) {
            println("Attachments:")
        }
        for (attachment in attachments) {
            println("\t" + attachment)
        }
        println(likes)
        comments?.print()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (authorId != other.authorId) return false
        if (authorName != other.authorName) return false
        if (content != other.content) return false
        if (likes != other.likes) return false
        if (!attachments.contentEquals(other.attachments)) return false
        if (comments != other.comments) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + authorId
        result = 31 * result + authorName.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + likes.hashCode()
        result = 31 * result + attachments.contentHashCode()
        result = 31 * result + (comments?.hashCode() ?: 0)
        return result
    }
}