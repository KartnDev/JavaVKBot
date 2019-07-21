package BotLogics.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public abstract class NetworkMethods {

    protected static final String httpUrl = "https://";
    public abstract String parseURL(String url);


}
