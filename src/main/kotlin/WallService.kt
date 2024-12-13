package ru.netology

import Post

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
}