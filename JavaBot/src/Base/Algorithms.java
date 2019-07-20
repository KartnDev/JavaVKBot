package Base;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.HashMap;

public class Algorithms {
    public static HashMap<String, String> toDict(String string) throws JsonParseException, JsonSyntaxException {
        Type type = new TypeToken<HashMap<String, String>>(){}.getType();
        HashMap<String, String> result = (new Gson()).fromJson(string, type);
        return result;
    }
    public static String stringToUnicode(String token) throws UnsupportedEncodingException {
       byte[] temp = token.getBytes("Unicode");
        String value = new String(temp, "Unicode");
        return value;
    }
}