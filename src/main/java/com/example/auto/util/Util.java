package com.example.auto.util;


import io.github.cdimascio.dotenv.Dotenv;

public class Util {

    public static String getEnv(String key) {
        try {
            String value = "";
            if (System.getProperty(key) != null && System.getProperty("browser").length() > 0) {
                value = System.getProperty(key);
            } else {
                Dotenv dotenv = Dotenv.configure().directory(System.getProperty("user.dir") + "/").filename("secret.env")
                        .load();
                value = dotenv.get(key);
            }
            return value;
        } catch (Exception e) {
            System.err.println("Not able to fetch env value.");
            return null;
        }
    }
}
