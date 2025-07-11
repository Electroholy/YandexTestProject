package tests;

import YandexBrowser.Initialization;
import YandexBrowser.imageLocators.BrowserInterfaceLocators;
import YandexBrowser.imageLocators.PikabuMiniAppLocators;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.*;

@Slf4j
public class BaseTest {

    protected WebDriver driver;
    protected Screen screen;

    @SneakyThrows
    @BeforeEach
    public void setUp() {
        log.info("Driver initializing\n");
        driver = Initialization.getDriver();
        screen = new Screen();
        log.info("Start test!\n");
    }

    @AfterEach
    public void tearDown() {
        log.info("Driver closing after test");
        Initialization.quitDriver();
    }

    @SneakyThrows
    public void openPikabuApp() {
        screen.click(BrowserInterfaceLocators.plusButtonSideBar);
        screen.click(BrowserInterfaceLocators.addAppButton);
        screen.type("pikabu.ru");

        Match searchResult = screen.exists(BrowserInterfaceLocators.searchResult, 10);
        screen.click(searchResult);

        Match pikabuApp = screen.exists(BrowserInterfaceLocators.pikabuApp, 10);
        screen.click(pikabuApp);
    }

    @SneakyThrows
    public void scrollDown() {
        screen.hover(PikabuMiniAppLocators.loginWithVK);
        screen.wheel(Mouse.WHEEL_DOWN, 20);
    }

    public void scrollUp() {
        screen.wheel(Mouse.WHEEL_UP, 20);
    }

    @SneakyThrows
    public void closeWindowAfterTest() {
        Match closeWindowButton = screen.exists(BrowserInterfaceLocators.closeWindow, 10);
        screen.click(closeWindowButton);
    }

    public Match foundElement (Pattern imageLocator) {
        return screen.exists(imageLocator, 10);
    }
}
