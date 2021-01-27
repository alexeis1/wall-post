package ru.netology.lesson5

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test fun update_checkText() {
        WallService.clear()
        val post1    = Post(id = 0, text ="text 1")
        val post2    = Post(id = 0, text ="text 2")
        val newPost1 = WallService.add(post1).copy(text = "new text1")
        val newPost2 = WallService.add(post2).copy(text = "new text2")
        val count = WallService.posts.count()
        WallService.update(newPost1)
        WallService.update(newPost2)
        val fountPost1 = WallService.posts.find { it.id == newPost1.id }
        val fountPost2 = WallService.posts.find { it.id == newPost2.id }

        assertNotNull(fountPost1)
        assertNotNull(fountPost2)
        assertEquals(fountPost1!!.text, "new text1")
        assertEquals(fountPost2!!.text, "new text2")
    }


}