package Main;
import BotLogics.VKMethods;

import java.net.URL;
public class Main {

	private static URL url;
	static final private String osuToken = "";
	static final private String http = "https://osu.ppy.sh/api/";
	static final private String getOsuProfile = "get_user?";
	//self.key + 'get_user_best?' + 'k=' + self.key + '&u' + user_id + '&m=' + str(self.mode))


	public static void main(String[] args) {

		VKMethods bot = new VKMethods("");
		bot.sendMessage("user_id", "376359640", "ролл");

	}

}
