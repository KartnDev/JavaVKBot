package BotLogics;

public class Bot{
    private String accessToken;
    private VKMethods vkMethods;
    public Bot(String accessToken){
        vkMethods = new VKMethods(accessToken);
        this.accessToken = accessToken;
    }
    public void sendMessageChat(String chatId, String message){
        vkMethods.sendMessage("chat_id", chatId, message);
    }
    public void sendMessageChat(String chatId, String message, String attachment){
        vkMethods.sendMessage("chat_id", chatId, message, attachment);
    }
    public void sendMessageUser(String userId, String message){
        vkMethods.sendMessage("user_id", userId, message);
    }
    public void sendMessageUser(String userId, String message, String attachment){
        vkMethods.sendMessage("user_id", userId, message);
    }
    public  void inviteToChat(String userId, String chatId){
        if(vkMethods.addToChat(userId, chatId) == 0){

        }   else {
            sendMessageChat(chatId, "Невозможно добавить пользователя...");
        }
    }
}
