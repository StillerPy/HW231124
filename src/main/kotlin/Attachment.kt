
abstract class Attachment {
    abstract val id: Int
    abstract val type: String
    override fun toString(): String {
        return "$type #$id"
    }
}

class PictureAttachment(override val id: Int, val width: Int, val height: Int): Attachment() {
    override val type = "Picture"
    override fun toString(): String {
        return "$type #$id Width: $width, Height: $height"
    }
}

class VideoAttachment(override val id: Int, val title: String, val duration: Double): Attachment() {
    override val type = "Video"
    override fun toString(): String {
        return "$type #$id Title: \"$title\", Duration: $duration"
    }
}

class AudioAttachment(override val id: Int, val title: String, val duration: Double): Attachment() {
    override val type = "Audio"
    override fun toString(): String {
        return "$type #$id Title: \"$title\", Duration: $duration"
    }
}

class FileAttachment(override val id: Int, val title: String): Attachment() {
    override val type = "File"
}

class LinkAttachment(override val id: Int, val url: String): Attachment() {
    override val type = "Link"
}
