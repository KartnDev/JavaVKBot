package BotLogics.Methods;
import Base.Algorithms;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Random;

public class VKMethods{
    private static final String URLAPI = "https://api.vk.com/method/";
    private static final String VERSION = "&v=5.101";
    private static final String ENDNAME = "?";
    private String accessToken;
    private URL api;
    public VKMethods(String apiToken){
        this.accessToken = "&access_token="+apiToken;
    }


    public int vkMethod(String methodName, String argsline){
        try{
            api = new URL(URLAPI + methodName + ENDNAME + argsline  +accessToken + VERSION);
            System.out.println(URLAPI + methodName + ENDNAME + argsline  +accessToken + VERSION);
            URLConnection apiRequest = api.openConnection();
            BufferedReader content = new BufferedReader(new InputStreamReader(apiRequest.getInputStream()));
            Algorithms algorithms = new Algorithms();

        }catch (MalformedURLException e){
            //  handling the exception
            //  watch inet connection
            //  retry to POST the api request
            System.out.println("Malformed URL exception");
            e.printStackTrace();
            return -1;
        } catch (JsonSyntaxException e) {
            System.out.println("JSON syntax exception");
            e.printStackTrace();
            return 1;
        } catch (JsonParseException e) {
            System.out.println("JSON parse exception");
            e.printStackTrace();
            return 1;
        } catch (Exception e){
            System.out.println("Unhandled exception");
            e.printStackTrace();
            return -100;
        }
        return 0;
    }

    public int sendMessage(String pushType, String id, String message){
        String argsLine = pushType+"=" + id + "&random_id="+(new Random()).nextInt() + "&message="+ message;
        return vkMethod("messages.send", argsLine);
    }

    public int sendMessage(String pushType, String id, String message, String attachment){
        String argsLine = pushType+"=" + id + "&random_id="+(new Random()).nextInt() + "&message="+ message +
                "&attachment=" + attachment;
        return vkMethod("messages.send", argsLine);
    }

    public  int removeFromChat(String userId, String chatId){
        return vkMethod("messages.removeChatUser", "chat_id="+ chatId + "&user_id="+userId);
    }

    public int addToChat(String userId, String chatId){
        return vkMethod("messages.addChatUser", "chat_id="+ chatId + "&user_id="+userId);
    }

}