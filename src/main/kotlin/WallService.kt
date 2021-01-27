package ru.netology.lesson5

import java.text.NumberFormat
import java.util.concurrent.atomic.AtomicInteger

/**
 * Description WallService
 * Сервис для хранения и добавления постов
 */

object WallService {
    var posts = emptyArray<Post>()
        private set(value){field = value}
    private var idGenerator = AtomicInteger()
    private fun generateId() : Int {return idGenerator.incrementAndGet()}
    /**
     * Description функция add добавляет новый пост в список с уникальным id
     * возвращает пост с назначенным id
     */
    fun add(post : Post) : Post {
        val uniqueIdPost = post.copy(id = generateId())
        posts += uniqueIdPost
        return uniqueIdPost
    }
    /**
     * Description функция update обновляет содержимое поста (по сути редактирование)
     */
    fun update(post: Post): Boolean
    {
        val (match, rest) = posts.partition { it.id == post.id }
        if (match.isNotEmpty())
        {
            posts = rest.plus(post.copy(id = match.first().id, date = match.first().date)).toTypedArray()
        }
        return match.isNotEmpty()
    }
    /**
     * Description функция clear удаляет все посты
     */
    fun clear(){
        posts = emptyArray<Post>()   
    }
}