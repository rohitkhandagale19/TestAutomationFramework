package com.epam.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}

