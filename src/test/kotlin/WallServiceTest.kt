import org.junit.Before
import org.junit.Test
import ru.netology.*


class WallServiceTest {
    @Before
    fun setUp() {
        WallService.clear()
    }
    @Test
    fun add() {
        val post = Post()
        val resultPost = WallService.add(post)
        assert(resultPost.id == 1)
    }
    @Test
    fun update1() {
        val post = Post()
        WallService.add(post)
        val newPost = Post(id = 1, content = "==New content==")
        val result = WallService.update(newPost)
        assert(result)
    }
    @Test
    fun update2() {
        val post = Post()
        WallService.add(post)
        val newPost = Post(id = 2, content = "==New content==")
        val result = WallService.update(newPost)
        assert(!result)
    }
    @Test
    fun createCommentNormally() {
        val postId = 1
        val post = Post(id = postId, comments = Comments())
        WallService.add(post)
        val comment = Comment()
        WallService.createComment(postId, comment)
        assert(WallService.getPostCount() == 1)
    }
    @Test(expected = PostNotCommentable::class)
    fun createCommentOnPostWithNoComments() {
        val postId = 1
        val post = Post(id = postId, comments = null)
        WallService.add(post)
        val comment = Comment()
        WallService.createComment(postId, comment)
    }
    @Test(expected = PostNotFound::class)
    fun createCommentOnNotExistingPost() {
        val postId = 1
        val wrongPostId = 2
        val post = Post(id = postId, comments = Comments())
        WallService.add(post)
        val comment = Comment()
        WallService.createComment(wrongPostId, comment)
    }
    @Test
    fun reportCommentNormally() {
        val postId = 1
        val commentId = 100
        val commenterId = 200
        val post = Post(id = postId, comments = Comments())
        WallService.add(post)
        val comment = Comment(id = commentId, fromId = commenterId)
        WallService.createComment(postId, comment)
        WallService.reportComment(commenterId, commentId, VIOLENCE_REPORT_CODE)
        assert(comment.isReported)
    }
    @Test(expected = CommentNotFound::class)
    fun reportCommentOnNotExistingComment() {
        val postId = 1
        val commentId = 100
        val wrongCommentId = 101
        val commenterId = 200
        val post = Post(id = postId, comments = Comments())
        WallService.add(post)
        val comment = Comment(id = commentId, fromId = commenterId)
        WallService.createComment(postId, comment)
        WallService.reportComment(commenterId, wrongCommentId, VIOLENCE_REPORT_CODE)
    }
    @Test(expected = IllegalArgumentException::class)
    fun reportCommentWrongReportCode() {
        val postId = 1
        val commentId = 100
        val commenterId = 200
        val post = Post(id = postId, comments = Comments())
        WallService.add(post)
        val comment = Comment(id = commentId, fromId = commenterId)
        WallService.createComment(postId, comment)
        WallService.reportComment(commenterId, commentId, 101)
    }
    @Test(expected = CommentNotFound::class)
    fun reportCommentWrongAuthorId() {
        val postId = 1
        val commentId = 100
        val commenterId = 200
        val wrongCommenterId = 201
        val post = Post(id = postId, comments = Comments())
        WallService.add(post)
        val comment = Comment(id = commentId, fromId = commenterId)
        WallService.createComment(postId, comment)
        WallService.reportComment(wrongCommenterId, commentId, VIOLENCE_REPORT_CODE)
    }
}