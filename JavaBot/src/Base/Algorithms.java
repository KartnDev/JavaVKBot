package Base;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Algorithms {
    public static LinkedTreeMap<String, Object> toDict(String string) throws JsonParseException, JsonSyntaxException {
        LinkedTreeMap<String, Object> result = (new Gson()).fromJson(string, LinkedTreeMap.class);
        return result;
    }
    public static String stringToUnicode(String token) throws UnsupportedEncodingException {
       byte[] temp = token.getBytes("Unicode");
        String value = new String(temp, "Unicode");
        return value;
    }
}