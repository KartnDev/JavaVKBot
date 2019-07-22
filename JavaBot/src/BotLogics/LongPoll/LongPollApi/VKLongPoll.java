package BotLogics.LongPoll.LongPollApi;

import Base.Algorithms;
import BotLogics.LongPoll.Events.VKEvents;
import BotLogics.Methods.VKMethods;
import com.google.gson.internal.LinkedTreeMap;

import java.util.LinkedList;
import java.util.Map;

public class VKLongPoll extends VKMethods {


    private LinkedList<String> MESSAGE_EXTRA_FIELDS;

    public VKLongPoll(String accessToken){
        super(accessToken);
        MESSAGE_EXTRA_FIELDS = new LinkedList<String>();
        MESSAGE_EXTRA_FIELDS.add("peer_id");
        MESSAGE_EXTRA_FIELDS.add("timestamp");
        MESSAGE_EXTRA_FIELDS.add("text");
        MESSAGE_EXTRA_FIELDS.add("extra_values");
        MESSAGE_EXTRA_FIELDS.add("attachments");
        MESSAGE_EXTRA_FIELDS.add("random_id");
    }




    private static final int CHAT_START_ID = 2000000000;
    private static final String longPollURL = "https://{$server}?act=a_check&key={$key}&ts={$ts}&wait=25&mode=2&version=2";
    private String serverNameSpace[] = null;
    private String serverName;
    private String serverIm;
    private String act = "";
    private String serverKey = "";
    private String pts = "";
    private String ts = "";
    private VKEvents DEFAULT_EVENT_CLASS = new VKEvents();
    enum PRELOAD_MESSAGE_EVENT { MESSAGE_NEW, MESSAGE_EDIT }


    public void startPool(){
        LinkedTreeMap<String, Object> request = getLongPollServer("3", 1).get("response");
        serverKey = (String)request.get("key");
        serverNameSpace = request.get("server").toString().split("/");
        serverName = serverNameSpace[0];
        serverIm = serverNameSpace[1];
        ts = request.get("ts").toString();
        pts = request.get("pts").toString();
        act = "a_check";
    }

    public LinkedTreeMap<String, Object> getVkLongPool(String ts){
        return  requestLongPoolServer(serverName, serverIm, act, serverKey, ts, "25" ,"2", "3");
    }
    public void run(){
        LinkedTreeMap<String, Object> request = getVkLongPool(String.valueOf(Double.valueOf(ts).intValue()));
        System.out.println(getVkLongPool(String.valueOf(Double.valueOf(ts).intValue())));
    }

}
