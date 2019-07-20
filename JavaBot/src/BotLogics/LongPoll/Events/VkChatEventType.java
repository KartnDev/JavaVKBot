package BotLogics.LongPoll.Events;

public class VkChatEventType {
/* Идентификатор типа изменения в чате */


            // Изменилось название беседы
    public static final int TITLE = 1;

            // Сменилась обложка беседы
    public static final int PHOTO = 2;

            // Назначен новый администратор
    public static final int ADMIN_ADDED = 3;

            // Изменены настройки беседы
    public static final int SETTINGS_CHANGED = 4;

            // Закреплено сообщение
    public static final int MESSAGE_PINNED = 5;

            // Пользователь присоединился к беседе
    public static final int USER_JOINED = 6;

            // Пользователь покинул беседу
    public static final int USER_LEFT = 7;

            // Пользователя исключили из беседы
    public static final int USER_KICKED = 8;

            // С пользователя сняты права администратора
    public static final int ADMIN_REMOVED = 9;

            // Бот прислал клавиатуру
    public static final int KEYBOARD_RECEIVED = 11;
}
