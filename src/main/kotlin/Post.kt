package ru.netology.lesson5

/**
 * Description data класс для размещения полей поста VK
 * согласно описанию https://vk.com/dev.php?method=post&prefix=objects
 */

//Игнорируйте поля post_source, attachments, geo, copy_history
data class Post(
    val id             : Int,          //идентификатор записи.
    val ownerId        : Int,          //идентификатор владельца стены, на которой размещена запись. В версиях API ниже 5.7 это поле называется to_id.
    val fromId         : Int,          //идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy      : Int,          //идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
    val date           : Int,          //время публикации записи в формате unixtime.
    val text           : String,       //текст записи.
    val replyOwnerId   : Int,          //идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId    : Int,          //идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly    : Boolean,      //true, если запись была создана с опцией «Только для друзей».
    val comments       : CommentsDesc, //информация о комментариях к записи, объект с полями:
    val copyright      : Copyright,    //источник материала
    val likes          : Likes,        //информация о лайках к записи, объект с полями:
    val reposts        : Reposts,      //информация о репостах записи («Рассказать друзьям»),
    val views_count    : Int,          //информация о просмотрах записи (число записей)
    val postType       : String,       //тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId       : Int,       //идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    val canPin         : Boolean,   //информация о том, может ли текущий пользователь закрепить запись
    val canDelete      : Boolean,   //информация о том, может ли текущий пользователь удалить запись
    val canEdit        : Boolean,   //информация о том, может ли текущий пользователь редактировать запись
    val isPinned       : Boolean,   //информация о том, что запись закреплена.
    val markedAsAds    : Boolean,   //информация о том, содержит ли запись отметку "реклама"
    val isFavorite     : Boolean,   //true, если объект добавлен в закладки у текущего пользователя.
    val donut          : VkDonut,   //информация о записи VK Donut:
    val postponedId    : Int        //идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
) {


}
/*
    val postType       : String = "post"
    fun set(value : String) {
        if (setOf("post", "copy", "reply", "postpone", "suggest").contains(value))
        {
            postType = value
        }
    }
*/

/**
 * Description SourceType
 * тип источника
 */
enum class SourceType(value : String){
    vk    ("vk"    ),// запись создана через основной интерфейс сайта (http://vk.com/);
    widget("widget"),//— запись создана через виджет на стороннем сайте;
    api   ("api"   ),//— запись создана приложением через API;
    rss   ("rss"   ),//— запись создана посредством импорта RSS-ленты со стороннего сайта;
    sms   ("sms"   ),//— запись создана посредством отправки SMS-сообщения на специальный номер.
}

/**
 * Description VkDonut
 * вспомогательный класс, который используется только вместе с Post
 * информация о записи VK Donut
 */
data class VkDonut(
    val isDonut            : Boolean,  // — запись доступна только платным подписчикам VK Donut;
    val paidDuration       : Int,      // — время, в течение которого запись будет доступна только платным подписчикам VK Donut;
    val placeholder        : String,   // — заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи
    val canPublishFreeCopy : Boolean,  // — можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
    val editMode           : String    // — информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
                     //all — всю информацию о VK Donut.
                     //duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut.
)
{

}

/**
 * Description Reposts
 * вспомогательный класс, который используется только вместе с Post
 * информация о репостах записи («Рассказать друзьям»)
 */
data class Reposts(
    val count        : Int,
    val userReposted : Boolean
)
{

}
/**
 * Description Likes
 * вспомогательный класс, который используется только вместе с Post
 * информация о лайках к записи
 */
data class Likes(
    val count      : Int,
    val userLikes  : Boolean,
    val canLike    : Boolean,
    val canPublish : Boolean
)
{
    
}

/**
 * Description CommentsDesc
 * вспомогательный класс, который используется только вместе с Post
 * информация о комментариях к записи
 */

data class CommentsDesc(
    val count         : Int,
    val canPost       : Boolean,
    val groupsCanPost : Boolean,
    val canClose      : Boolean,
    val canOpen       : Boolean
){

}

/**
 * Description Copyright
 * вспомогательный класс, который используется только вместе с Post
 * источник материала
 */
data class Copyright(
    val id   : Int,
    val link : String,
    val name : String,
    val type : String,
){

}

