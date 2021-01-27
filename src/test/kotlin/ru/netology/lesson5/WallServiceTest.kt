package ru.netology.lesson5

import org.junit.Assert
import org.junit.Test

class WallServiceTest {

    @Test
    fun update_IdFound() {
        WallService.clear()
        val post1      = Post(id = 0, text = "text 1")
        val postWithId = WallService.add(post1)
        WallService.update(postWithId).apply {
            Assert.assertTrue(this)
        }
    }

    @Test
    fun update_IdNotFound() {
        val post1      = Post(id = 0, text = "text 1")
        val postWithId = WallService.add(post1)
        //удаляем все посты, теперь update не найдет id
        WallService.clear()
        WallService.update(postWithId).apply {
            Assert.assertFalse(this)
        }
    }

    @Test
    fun add_checkId() {
        WallService.clear()
        val post1      = Post(id = 0, text = "text 1")
        val postWithId = WallService.add(post1)
        Assert.assertNotEquals(0, postWithId)
    }

    /**
     * Description тест проверяет что функция update обновила содержимое поля текст
     */
    @Test
    fun update_checkText() {
        WallService.clear()
        val post1    = Post(id = 0, text = "text 1")
        val post2    = Post(id = 0, text = "text 2")
        val newPost1 = WallService.add(post1).copy(text = "new text1")
        val newPost2 = WallService.add(post2).copy(text = "new text2")
        val count = WallService.posts.count()
        Assert.assertEquals(2, count)
        
        WallService.update(newPost1)
        WallService.update(newPost2)
        val fountPost1 = WallService.posts.find { it.id == newPost1.id }
        val fountPost2 = WallService.posts.find { it.id == newPost2.id }

        Assert.assertNotNull(fountPost1)
        Assert.assertNotNull(fountPost2)
        Assert.assertEquals(fountPost1!!.text, "new text1")
        Assert.assertEquals(fountPost2!!.text, "new text2")
    }

}