package BotLogics;

import Base.Algorithms;
import BotLogics.Methods.VKMethods;

import static java.lang.Integer.parseInt;

public class Bot{
    private String accessToken;
    private VKMethods vkMethods;
    public Bot(String accessToken){
        vkMethods = new VKMethods(accessToken);
        this.accessToken = accessToken;
    }
    public void sendMessageChat(String chatId, String message){
        if(vkMethods.sendMessage("chat_id", chatId, message) != 0){
            System.out.println("Something went wrong while sending message\n Probably.. IO or Net exception");
        }
    }


    public void sendMessageChat(String chatId, String message, String attachment){

        if(vkMethods.sendMessage("chat_id", chatId, message, attachment) != 0){
            System.out.println("Something went wrong while sending message\n Probably.. IO or Net exception");
        }
    }


    public void sendMessageUser(String userId, String message){
        if(vkMethods.sendMessage("user_id", userId, message) != 0){
            System.out.println("Something went wrong while sending message\n Probably.. IO or Net exception");
        }
    }


    public void sendMessageUser(String userId, String message, String attachment){
        if(vkMethods.sendMessage("user_id", userId, message) != 0){
            System.out.println("Something went wrong while sending message\n Probably.. IO or Net exception");
        }
    }


    public  void inviteToChat(String userId, String chatId){
        int funcValidation = vkMethods.addToChat(userId, chatId);
        if(funcValidation == 0){
        }else if(funcValidation == 1){
            sendMessageChat(chatId, "Невозможно добавить пользователя...");
        }else{
            System.out.println("InviteToChat: ошибка добавления -> нет доступа к API");
        }
    }


    public void banInChat(String userId, String chatId){
        int funcValidation = vkMethods.removeFromChat(userId, chatId);

        if(funcValidation == 0){
            sendMessageChat(chatId, "Забанен на всегда! (без причины)");
        }else if(funcValidation == 1){
            sendMessageChat(chatId, "Невозможно исключить пользователя...");
        }else{
            System.out.println("BanInChat: ошибка удаления пользователя -> нет доступа к API");
        }
    }

    public void banInChat(String userId, String chatId, String time) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int offset = parseInt(time);
                    int funcValidation = vkMethods.removeFromChat(userId, chatId);
                    if(funcValidation == 0){
                        sendMessageChat(chatId, Algorithms.stringToUnicode("Забанен на "));
                    }else if(funcValidation == 1){
                        sendMessageChat(chatId, "Невозможно исключить пользователя...");
                    }else{
                        System.out.println("BanInChat: ошибка удаления пользователя -> нет доступа к API");
                    }
                    Thread.sleep(offset*1000);
                    inviteToChat(userId, chatId);
                } catch (Exception e) {

                }
            }
        }).start();
    }
    public void banInChat(String userId, String chatId, String time, String reason){
        int funcValidation = vkMethods.removeFromChat(userId, chatId);
    }
}