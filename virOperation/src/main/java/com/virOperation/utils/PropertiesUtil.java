package com.virOperation.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties properties = new Properties();
    private static String pathName = "settings.properties";
    public static final String intervaTime = "interval.time";
//    private static String pathName = "src/main/resources/settings.properties";

    public static void initProperties() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream is = classLoader.getResourceAsStream(pathName);
            properties.load(is);
            System.out.println("load properties ok!");
        } catch (Exception e) {
            properties.setProperty(intervaTime, "1");
            e.printStackTrace();
        }
    }
}
