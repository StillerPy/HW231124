package ru.netology

import Post

class PostNotFound(text: String): Exception(text)
class PostNotCommentable(text: String): Exception(text)
class CommentNotFound(text: String): Exception(text)
val SPAM_REPORT_CODE = 0
val CP_REPORT_CODE = 1
val EXTREMISM_REPORT_CODE = 2
val VIOLENCE_REPORT_CODE = 3
val DRUGS_REPORT_CODE = 4
val ADULT_REPORT_CODE = 5
val INSULT_REPORT_CODE = 6
val OTHER_REPORT_CODE = 7
val SUICIDE_REPORT_CODE = 8

object WallService {
    private var posts = mutableListOf<Post>()
    private var postCount = 0

    fun add(post: Post): Post {
        val newPost = post.copy(id = postCount + 1)
        posts += newPost
        postCount += 1
        return newPost
    }
    fun update(post: Post): Boolean {
        for ((i, oldPost) in posts.withIndex()) {
            if (oldPost.id == post.id) {
                posts[i] = post
                return true
            }
        }
        return false
    }
    fun clear() {
        postCount = 0
        posts = mutableListOf()
    }
    fun getPostCount(): Int {
        return postCount
    }
    fun createComment(postId: Int, comment: Comment): Comment {
        var post: Post? = posts.find { it.id == postId }
        if (post == null) {
            throw PostNotFound("Post with ID $postId doesn't exist")
        }
        if (post.comments == null) {
            throw PostNotCommentable("Post with ID $postId cannot be commented")
        }
        post.comments!!.add(comment)
        return comment
    }
    fun reportComment(ownerId: Int, commentId: Int, reportCode: Int): Comment {
        var comment: Comment? = null
        for (post in posts) {
            if (post.comments != null) {
                comment = post.comments.list.find { it.id == commentId }
            }
        }
        if (comment == null) {
            throw CommentNotFound("Comment with ID $commentId doesn't exist")
        }
        if (comment.fromId != ownerId) {
            throw CommentNotFound("Comment with ID $commentId has another author ID: ${comment.fromId}")
        }
        if (reportCode < 0 || reportCode > 8) {
            throw IllegalArgumentException("Report code must be between 0 and 8")
        }
        comment.isReported = true
        return comment
    }
}