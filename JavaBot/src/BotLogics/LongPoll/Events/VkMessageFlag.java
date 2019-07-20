package BotLogics.LongPoll.Events;

public class VkMessageFlag {


     /* Флаги сообщений */

             // Сообщение не прочитано.
    public static final int UNREAD = 1;

            // Исходящее сообщение.
    public static final int OUTBOX = 2;

            // На сообщение был создан ответ.
    public static final int  REPLIED = 4;

            // Помеченное сообщение.
    public static final int IMPORTANT = 8;

            // Сообщение отправлено через чат.
    public static final int CHAT = 16;

            // Сообщение отправлено другом.
            // Не применяется для сообщений из групповых бесед.
    public static final int  FRIENDS = 32;

            // Сообщение помечено как "Спам".
    public static final int SPAM = 64;

           // Сообщение удалено (в корзине).
    public static final int DELETED = 128;

           // Сообщение проверено пользователем на спам.
    public static final int FIXED = 256;

            // Сообщение содержит медиаконтент
    public static final int MEDIA = 512;

            // Приветственное сообщение от сообщества.
    public static final int HIDDEN = 65536;

            // Сообщение удалено для всех получателей.
    public static final int DELETED_ALL = 131072;


}
