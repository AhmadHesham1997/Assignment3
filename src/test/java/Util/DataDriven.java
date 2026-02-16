package Util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;

public class DataDriven {
    @DataProvider(name = "loginData")
    public static Object[][] jsonReader() throws IOException {

        FileReader reader = new FileReader("testData/testData.json");
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject object = new JSONObject(tokener);

        JSONArray loginData = object.getJSONArray("loginData");

        Object[][] data = new Object[loginData.length()][3];

        for (int i = 0; i < loginData.length(); i++) {
            JSONObject user = loginData.getJSONObject(i);

            data[i][0] = user.getString("username");
            data[i][1] = user.getString("password");
            data[i][2] = user.getString("type");
        }

        return data;
    }
}
