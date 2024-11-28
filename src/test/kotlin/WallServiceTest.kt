import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.netology.Post
import ru.netology.WallService


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
        val newPost = Post(id=1, content="==New content==")
        val result = WallService.update(newPost)
        assert(result)
    }
    @Test
    fun update2() {
        val post = Post()
        WallService.add(post)
        val newPost = Post(id=2, content="==New content==")
        val result = WallService.update(newPost)
        assert(!result)
    }
}