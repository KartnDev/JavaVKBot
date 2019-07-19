package Base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.HashMap;

public class Algorithms {
    public HashMap<String, String> toDict(String string) throws ParseException {
        Type type = new TypeToken<HashMap<String, String>>(){}.getType();
        HashMap<String, String> result = (new Gson()).fromJson(string, type);
        return result;
    }

}
