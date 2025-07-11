package YandexBrowser.utils;

import YandexBrowser.Initialization;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class Helper {

    static Properties config = new Properties();

    static {
        try (InputStream input = Initialization.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                log.error("Configuration file is empty");
            }
            config.load(input);
        } catch (Exception e) {
            log.error("Failed load configuration");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String getValue (String key) {
        return config.getProperty(key);
    }
}


