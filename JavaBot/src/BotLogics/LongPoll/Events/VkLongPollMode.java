package BotLogics.LongPoll.Events;

public class VkLongPollMode {

            // Получать вложения
    public static final int GET_ATTACHMENTS = 2;

            // Возвращать расширенный набор событий
    public static final int GET_EXTENDED = 8; // 2 в степени 3

            // возвращать pts для метода `messages.getLongPollHistory`
    public static final int GET_PTS = 32; // 2 в степени 5

            // В событии с кодом 8 (друг стал онлайн) возвращать
            // дополнительные данные в поле `extra`
    public static final int GET_EXTRA_ONLINE = 64; // 2 в степени 6

            // Возвращать поле `random_id`
    public static final int GET_RANDOM_ID = 128; // 2 в степени 7

}
