package ru.netology.lesson5

/**
 * Description
 * класс  PostSource, описывающий способ размещения записи на стене
 */

class PostSource(
    type      : String, // Варианты из SourceType
    platform  : String, // Варианты Platform
    data      : String, // Варианты из ActionType
    url       : String, // URL ресурса, с которого была опубликована запись.
) {
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
     * Description Platform
     * название платформы
     */
    enum class Platform(value : String){
        android("android"),
        iphone ("iphone"),
        wphone ("wphone")
    }

    /**
     * Description ActionType
     * тип действия (только для type = vk или widget). Возможные значения:
     */
    enum class ActionType(value : String){
        profileActivity("profile_activity"), // — изменение статуса под именем пользователя (для type = vk);
        profilePhoto   ("profile_photo"   ), // — изменение профильной фотографии пользователя (для type = vk);
        comments        ("comments"        ), // — виджет комментариев (для type = widget);
        like            ("like"            ), // — виджет «Мне нравится» (для type = widget);
        poll            ("poll"            )  // — виджет опросов (для type = widget);
    }
}