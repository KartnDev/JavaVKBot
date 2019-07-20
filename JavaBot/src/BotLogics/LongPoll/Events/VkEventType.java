package BotLogics.LongPoll.Events;

public class VkEventType {
    /*Перечисление событий, получаемых от longPoll-сервера.

    `Подробнее в документации VK API
    <https://vk.com/dev/using_longpoll?f=3.+Структура+событий>`__
    */
            // Замена флагов сообщения (FLAGS:=$flags)
    public static final int MESSAGE_FLAGS_REPLACE = 1;

            // Установка флагов сообщения (FLAGS|=$mask)
    public static final int MESSAGE_FLAGS_SET = 2;

            // Сброс флагов сообщения (FLAGS&=~$mask)
    public static final int  MESSAGE_FLAGS_RESET = 3;

            // Добавление нового сообщения.
    public static final int MESSAGE_NEW = 4;

            //Редактирование сообщения.
    public static final int MESSAGE_EDIT = 5;

            // Прочтение всех входящих сообщений в $peer_id,
            // пришедших до сообщения с $local_id.
    public static final int READ_ALL_INCOMING_MESSAGES = 6;

            // Прочтение всех исходящих сообщений в $peer_id,
            // пришедших до сообщения с $local_id.
    public static final int READ_ALL_OUTGOING_MESSAGES = 7;

            // Друг $user_id стал онлайн. $extra не равен 0, если в mode был передан флаг 64.
            // В младшем байте числа extra лежит идентификатор платформы
            // (см. :class:`VkPlatform`).
            // $timestamp — время последнего действия пользователя $user_id на сайте.
    public static final int USER_ONLINE = 8;

            // Друг $user_id стал оффлайн ($flags равен 0, если пользователь покинул сайт и 1,
            // если оффлайн по таймауту). $timestamp — время последнего действия пользователя
            // $user_id на сайте.
    public static final int USER_OFFLINE = 9;

            // Сброс флагов диалога $peer_id.
            // Соответствует операции (PEER_FLAGS &= ~$flags).
            // Только для диалогов сообществ.
    public static final int PEER_FLAGS_RESET = 10;

            // Замена флагов диалога $peer_id.
            // Соответствует операции (PEER_FLAGS:= $flags).
            // Только для диалогов сообществ.
    public static final int PEER_FLAGS_REPLACE = 11;

            // Установка флагов диалога $peer_id.
            // Соответствует операции (PEER_FLAGS|= $flags).
            // Только для диалогов сообществ.
    public static final int PEER_FLAGS_SET = 12;

            // Удаление всех сообщений в диалоге $peer_id с идентификаторами вплоть до $local_id.
    public static final int PEER_DELETE_ALL = 13;

            // Восстановление недавно удаленных сообщений в диалоге $peer_id с
            // идентификаторами вплоть до $local_id.
    public static final int PEER_RESTORE_ALL = 14;

            // Один из параметров (состав, тема) беседы $chat_id были изменены.
            // $self — 1 или 0 (вызваны ли изменения самим пользователем).
    public static final int CHAT_EDIT = 51;

            // Изменение информации чата $peer_id с типом $type_id
            // $info — дополнительная информация об изменениях
    public static final int CHAT_UPDATE = 52;

            // Пользователь $user_id набирает текст в диалоге.
            // Событие приходит раз в ~5 секунд при наборе текста. $flags = 1.
    public static final int USER_TYPING = 61;

            // Пользователь $user_id набирает текст в беседе $chat_id.
    public static final int USER_TYPING_IN_CHAT = 62;

            // Пользователь $user_id записывает голосовое сообщение в диалоге/беседе $peer_id
    public static final int USER_RECORDING_VOICE = 64;

            // Пользователь $user_id совершил звонок с идентификатором $call_id.
    public static final int USER_CALL = 70;

            // Счетчик в левом меню стал равен $count.
    public static final int MESSAGES_COUNTER_UPDATE = 80;

            // Изменились настройки оповещений.
            // $peer_id — идентификатор чата/собеседника,
            // $sound — 1/0, включены/выключены звуковые оповещения,
            // $disabled_until — выключение оповещений на необходимый срок.
    public static final int NOTIFICATION_SETTINGS_UPDATE = 114;
}
