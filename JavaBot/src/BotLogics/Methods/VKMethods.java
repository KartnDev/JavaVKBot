package BotLogics.Methods;
import Base.Algorithms;
import BotLogics.net.NetworkMethods;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VKMethods  extends NetworkMethods{
    private static final String URL_API = "https://api.vk.com/method/";
    private static final String VERSION = "&v=5.101";
    private static final String END_NAME = "?";
    private String accessToken;
    private URL api;
    public VKMethods(String apiToken){
        this.accessToken = "&access_token="+apiToken;
    }





    @Override
    public String parseURL(String url) {
        try {
            System.out.println(url);
            return (new BufferedReader(new InputStreamReader((new URL(url)).openConnection().getInputStream()))).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "exceptedString";
    }




    protected int vkMethod(String methodName, String argsLine){
        try{
            api = new URL(URL_API + methodName + END_NAME + argsLine  +accessToken + VERSION);
            System.out.println(URL_API + methodName + END_NAME + argsLine  +accessToken + VERSION);
            URLConnection apiRequest = api.openConnection();
            BufferedReader content = new BufferedReader(new InputStreamReader(apiRequest.getInputStream()));
            Algorithms algorithms = new Algorithms();

        }catch (MalformedURLException e){
            //  handling the exception
            //  watch net connection
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

    protected String vkMethod(String methodName, String argsLine, boolean needJSON){
        if(needJSON) {
            try {
                api = new URL(URL_API + methodName + END_NAME + argsLine + accessToken + VERSION);
                System.out.println(URL_API + methodName + END_NAME + argsLine + accessToken + VERSION);
                URLConnection apiRequest = api.openConnection();
                BufferedReader content = new BufferedReader(new InputStreamReader(apiRequest.getInputStream()));
                return content.readLine();
            } catch (MalformedURLException e) {
                //  handling the exception
                //  watch inet connection
                //  retry to POST the api request
                System.out.println("Malformed URL exception");
                e.printStackTrace();

            } catch (Exception e) {
                System.out.println("Unhandled exception");
                e.printStackTrace();

            }
            return "null";
        } else {
            return ("" + vkMethod(methodName, argsLine));
        }
    }

    protected int sendMessage(String pushType, String id, String message){
        String argsLine = pushType+"=" + id + "&random_id="+(new Random()).nextInt() + "&message="+ message;
        return vkMethod("messages.send", argsLine);
    }

    protected int sendMessage(String pushType, String id, String message, String attachment){
        String argsLine = pushType+"=" + id + "&random_id="+(new Random()).nextInt() + "&message="+ message +
                "&attachment=" + attachment;
        return vkMethod("messages.send", argsLine);
    }

    protected   int removeFromChat(String userId, String chatId){
        return vkMethod("messages.removeChatUser", "chat_id="+ chatId + "&user_id="+userId);
    }

    protected int addToChat(String userId, String chatId){
        return vkMethod("messages.addChatUser", "chat_id="+ chatId + "&user_id="+userId);
    }


    protected Map<String, LinkedTreeMap<String, Object>> getLongPollServer(String version, int needPts){
        /* version is a value from 1 to 3
        * correct version is 3
        * need pts is a boolean (1 or 0)
        * to get pts key
        * returns pts for vk method 'messages.getLongPollHistory'
        * */
        String request = vkMethod("messages.getLongPollServer", "lp_version="  + version +
                "&need_pts=" + needPts, true);
        Map map = (new Gson()).fromJson(request, Map.class);
        return  map;
    }

    //TODO проблема: ключ ts перееводится в дабл и подается нее правильно как токен
    protected LinkedTreeMap<String, Object> requestLongPoolServer(String serverName, String serverIm, String act, String longPoolKey,
                                                        String ts, String wait, String mode, String version) {
        String url = NetworkMethods.httpUrl + serverName +"/" +serverIm  + "?" + "act="+ act + "&key=" + longPoolKey + "&ts=" + ts + "&wait="
                + wait + "&mode=" + mode + "&version=" + version;
        return Algorithms.toDict(parseURL(url));
    }


}