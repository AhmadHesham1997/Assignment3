package Util;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.DataProvider;

public class DataDriven {

    // ---------------------------------
    // 1️⃣ For InventoryPageTest: valid logins only
    // ---------------------------------
    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() throws IOException {
        return getFilteredLoginData("valid");
    }

    // ---------------------------------
    // 2️⃣ For LoginTest: all logins (valid + invalid)
    // ---------------------------------
    @DataProvider(name = "loginData")
    public static Object[][] loginData() throws IOException {
        return getFilteredLoginData(null); // null = return all types
    }

    // ---------------------------------
    // Helper method: filters by type if provided
    // ---------------------------------
    private static Object[][] getFilteredLoginData(String typeFilter) throws IOException {

        InputStream inputStream = DataDriven.class.getClassLoader()
                .getResourceAsStream("testData/testData.json");

        if (inputStream == null) {
            throw new RuntimeException("JSON file not found in resources folder!");
        }

        JSONTokener tokener = new JSONTokener(inputStream);
        JSONObject object = new JSONObject(tokener);
        JSONArray loginData = object.getJSONArray("loginData");

        // Count rows that match filter
        int count = 0;
        for (int i = 0; i < loginData.length(); i++) {
            JSONObject user = loginData.getJSONObject(i);
            if (typeFilter == null || typeFilter.equalsIgnoreCase(user.getString("type"))) {
                count++;
            }
        }

        Object[][] data = new Object[count][3]; // username, password, type
        int index = 0;
        for (int i = 0; i < loginData.length(); i++) {
            JSONObject user = loginData.getJSONObject(i);
            if (typeFilter == null || typeFilter.equalsIgnoreCase(user.getString("type"))) {
                data[index][0] = user.getString("username");
                data[index][1] = user.getString("password");
                data[index][2] = user.getString("type"); // keep type for LoginTest if needed
                index++;
            }
        }

        return data;
    }
}

