
abstract class Attachment {
    abstract val id: Int
    abstract val type: String
    override fun toString(): String {
        return "$type #$id"
    }
}
class PictureAttachment(override val id: Int, val picture: Picture): Attachment() {
    override val type = "picture"
    override fun toString(): String {
        return "$type #$id Picture: $picture"
    }
}
class VideoAttachment(override val id: Int, val video: Video): Attachment() {
    override val type = "video"
    override fun toString(): String {
        return "$type #$id Video: $video"
    }
}
class AudioAttachment(override val id: Int, val audio: Audio): Attachment() {
    override val type = "audio"
    override fun toString(): String {
        return "$type #$id Audio: $audio"
    }
}
class FileAttachment(override val id: Int, val file: FileAttached): Attachment() {
    override val type = "file"
    override fun toString(): String {
        return "$type #$id File: $file"
    }
}
class LinkAttachment(override val id: Int, val link: Link): Attachment() {
    override val type = "link"
    override fun toString(): String {
        return "$type #$id Link: $link"
    }
}

class Attachments: ArrayList<Attachment>()

data class Picture(val title: String, val width: Int, val height: Int)
data class Audio(val title: String, val duration: Double)
data class Video(val title: String, val duration: Double)
data class FileAttached(val title: String, val size: Int)
data class Link(val title: String, val url: String)
