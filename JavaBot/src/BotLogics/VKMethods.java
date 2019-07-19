package BotLogics;
import Base.Algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Random;

public class VKMethods {
    private static final String URLAPI = "https://api.vk.com/method/";
    private static final String VERSION = "&v=5.101";
    private static final String ENDNAME = "?";
    private String accessToken;
    private URL api;
    public VKMethods(String apitoken){
        this.accessToken = "&access_token="+apitoken;
    }


    public int vkMethod(String methodname, String argsline){
        try{
            api = new URL(URLAPI + methodname + ENDNAME + argsline  +accessToken + VERSION);
            System.out.println(URLAPI + methodname + ENDNAME + argsline  +accessToken + VERSION);
            URLConnection apiRequest = api.openConnection();
            BufferedReader content = new BufferedReader(new InputStreamReader(apiRequest.getInputStream()));
            Algorithms algs = new Algorithms();
            System.out.println(algs.toDict(content.readLine()).get("response"));




        }catch (MalformedURLException e){
            //  handling the exception
            //  watch inet connection
            //  retry to POST the api request
            e.printStackTrace();
            return -1;
        } catch (ParseException e) {

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

}
