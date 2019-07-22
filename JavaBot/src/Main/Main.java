package Main;
import BotLogics.Bot;
import BotLogics.LongPoll.LongPollApi.VKLongPoll;
import BotLogics.net.NetworkMethods;
import java.net.URL;
public class Main {

    private static URL url;
    static final private String osuToken = "";
    static final private String http = "https://osu.ppy.sh/api/";
    static final private String getOsuProfile = "get_user?";
    //self.key + 'get_user_best?' + 'k=' + self.key + '&u' + user_id + '&m=' + str(self.mode))

    //TODO rewrite BotBan
    public static void main(String[] args) throws Exception{

        Bot bot = new Bot("");
        VKLongPoll longPoll = new VKLongPoll("");
        longPoll.startPool();
        longPoll.run();
    }

}