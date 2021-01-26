package ru.netology.lesson5

object WallService {
    private var posts = emptyArray<Post>()

    /**
     * Description добавляет новый пост в список
     * возвращает индекс добавленного поста
     */
    fun add(post : Post) : Int {
        posts += post
        return posts.lastIndex
    }

    fun clear(){
        posts = emptyArray<Post>()   
    }
}