package configurations;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrlUi() {
        return properties.getProperty("url_ui");
    }
    public static String browserName() {
        return properties.getProperty("browser");
    }
    public static String usernameUi() {
        return properties.getProperty("username_ui");
    }
    public static String passwordUi() {
        return properties.getProperty("password_ui");
    }
    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
    public static int timeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }
}

