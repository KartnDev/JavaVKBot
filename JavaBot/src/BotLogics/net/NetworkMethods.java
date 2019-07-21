package BotLogics.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NetworkMethods {

    public static void checkURL(String url){
        try {
            System.out.println((new BufferedReader(new InputStreamReader((new URL(url)).openConnection().getInputStream()))).readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
