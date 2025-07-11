package YandexBrowser;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class Initialization {

    private static WebDriver driver;
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

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        try {
            System.setProperty(config.getProperty("driver.key"), config.getProperty("driver.path"));
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\1\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            options.addArguments("--user-data-dir=C:\\Users\\1\\AppData\\Local\\Yandex\\YandexBrowser\\User Data");
            options.addArguments("--profile-directory=Profile 1");
            driver = new ChromeDriver(options);
            log.info("Successful driver initialization");
        } catch (Exception e) {
            log.error("Unsuccessful driver initialization");
            throw new RuntimeException(e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
