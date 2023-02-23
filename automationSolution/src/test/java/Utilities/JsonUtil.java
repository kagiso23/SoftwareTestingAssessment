package Utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



import java.io.FileReader;

public class JsonUtil {
    public static JsonObject readJSON(String ObjectName, String jsonFile) throws Exception {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader(jsonFile);
        Object obj = jsonParser.parse(reader);
        JsonObject dataObject = (JsonObject) obj;
        JsonArray dataArray = (JsonArray) dataObject.get(ObjectName);
        JsonObject values = null;
        for (int i = 0; i < dataArray.size(); i++) {
            values = (JsonObject) dataArray.get(i);
        }
        return values;
    }

}