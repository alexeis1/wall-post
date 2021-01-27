package ru.netology.lesson5

/**
 * Description data класс для размещения полей поста VK
 * согласно описанию https://vk.com/dev.php?method=post&prefix=objects
 */

//Игнорируйте поля post_source, attachments, geo, copy_history
data class Post(
    val id             : Int = 0,          //идентификатор записи.
    val ownerId        : Int = 0,          //идентификатор владельца стены, на которой размещена запись. В версиях API ниже 5.7 это поле называется to_id.
    val fromId         : Int = 0,          //идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy      : Int = 0,          //идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
    val date           : Int = 0,          //время публикации записи в формате unixtime.
    val text           : String = "",      //текст записи.
    val replyOwnerId   : Int = 0,          //идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId    : Int = 0,          //идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly    : Boolean = false,  //true, если запись была создана с опцией «Только для друзей».
    val comments       : CommentsDesc = CommentsDesc(), //информация о комментариях к записи, объект с полями:
    val copyright      : Copyright    = Copyright(),    //источник материала
    val likes          : Likes        = Likes(),        //информация о лайках к записи, объект с полями:
    val reposts        : Reposts      = Reposts(),      //информация о репостах записи («Рассказать друзьям»),
    val views_count    : Int = 0,             //информация о просмотрах записи (число записей)
    val postType       : String = "",         //тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId       : Int = 0,             //идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    val canPin         : Boolean = false,     //информация о том, может ли текущий пользователь закрепить запись
    val canDelete      : Boolean = false,     //информация о том, может ли текущий пользователь удалить запись
    val canEdit        : Boolean = false,     //информация о том, может ли текущий пользователь редактировать запись
    val isPinned       : Boolean = false,     //информация о том, что запись закреплена.
    val markedAsAds    : Boolean = false,     //информация о том, содержит ли запись отметку "реклама"
    val isFavorite     : Boolean = false,     //true, если объект добавлен в закладки у текущего пользователя.
    val donut          : VkDonut = VkDonut(), //информация о записи VK Donut:
    val postponedId    : Int = 0              //идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
) {


}

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
    val isDonut            : Boolean = false, // — запись доступна только платным подписчикам VK Donut;
    val paidDuration       : Int = 0,         // — время, в течение которого запись будет доступна только платным подписчикам VK Donut;
    val placeholder        : String = "",     // — заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи
    val canPublishFreeCopy : Boolean = false, // — можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
    val editMode           : String = "all"   // — информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
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
    val count        : Int = 0,
    val userReposted : Boolean = false
)
{

}
/**
 * Description Likes
 * вспомогательный класс, который используется только вместе с Post
 * информация о лайках к записи
 */
data class Likes(
    val count      : Int = 0,
    val userLikes  : Boolean = false,
    val canLike    : Boolean = false,
    val canPublish : Boolean = false
)
{
    
}

/**
 * Description CommentsDesc
 * вспомогательный класс, который используется только вместе с Post
 * информация о комментариях к записи
 */

data class CommentsDesc(
    val count         : Int = 0,
    val canPost       : Boolean = false,
    val groupsCanPost : Boolean = false,
    val canClose      : Boolean = false,
    val canOpen       : Boolean = false
){

}

/**
 * Description Copyright
 * вспомогательный класс, который используется только вместе с Post
 * источник материала
 */
data class Copyright(
    val id   : Int = 0,
    val link : String = "",
    val name : String = "",
    val type : String = "",
){

}

