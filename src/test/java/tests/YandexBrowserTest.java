package tests;

import YandexBrowser.imageLocators.BrowserInterfaceLocators;
import YandexBrowser.imageLocators.PikabuMiniAppLocators;
import lombok.SneakyThrows;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sikuli.script.Match;
import static org.junit.jupiter.api.Assertions.assertAll;

public class YandexBrowserTest extends BaseTest {

    @SneakyThrows
    @Test
    @DisplayName("Test case 1-3, step 1")
    public void testYandexBrowserLaunch () {
        Match searchField = foundElement(BrowserInterfaceLocators.searchField);

        Assertions.assertNotNull(searchField, "Unsuccessful browser launch");
        Assertions.assertNotNull(driver, "Driver is null, unsuccessful browser launch");
    }

    @SneakyThrows
    @Test
    @DisplayName("Test case 1, step 2")
    public void testYandexMailLaunch() {
        screen.click(BrowserInterfaceLocators.yandexMail);

        Match goBackButton = foundElement(BrowserInterfaceLocators.goBackButton);
        Match windowControlButton = foundElement(BrowserInterfaceLocators.windowControlButton);
        Match windowModeSwitchButton = foundElement(BrowserInterfaceLocators.windowModeSwitchButton);
        Match notFullScreenMailApp = foundElement(BrowserInterfaceLocators.notFullScreenMailApp);

        assertAll("Yandex mail elements check",
                () -> Assertions.assertNotNull(goBackButton, "Go Back button not found"),
                () -> Assertions.assertNotNull(windowControlButton, "Window control button not found"),
                () -> Assertions.assertNotNull(windowModeSwitchButton, "Window mode switch button not found"),
                () -> Assertions.assertNotNull(notFullScreenMailApp, "Mail app in fullscreen"));
    }

    @SneakyThrows
    @Test
    @DisplayName("Test case 2, steps 1-6")
    public void testBuiltInBrowserApp () {

        // Step 2 (Нажать на кнопку "+" в боковой панели)
        screen.click(BrowserInterfaceLocators.plusButtonSideBar);
        Match firstAppCategory = foundElement(BrowserInterfaceLocators.firstAppCategory);
        Match secondAppCategory = foundElement(BrowserInterfaceLocators.secondAppCategory);
        Match thirdAppCategory = foundElement(BrowserInterfaceLocators.thirdAppCategory);
        Match arrowToSideBalloon = foundElement(BrowserInterfaceLocators.arrowToSideBalloon);
        Match addAppButton = foundElement(BrowserInterfaceLocators.addAppButton);
        assertAll("Balloon elements check",
                () -> Assertions.assertNotNull(firstAppCategory, "App not divided into categories"),
                () -> Assertions.assertNotNull(secondAppCategory, "App not divided into categories"),
                () -> Assertions.assertNotNull(thirdAppCategory, "App not divided into categories"),
                () -> Assertions.assertNotNull(arrowToSideBalloon, "Arrow not found"),
                () -> Assertions.assertNotNull(addAppButton, "Add app button not found"));

        // Step 3 (Нажать на кнопку "Добавить сайт как приложение")
        screen.click(BrowserInterfaceLocators.addAppButton);
        Match inputField = foundElement(BrowserInterfaceLocators.inputField);
        Assertions.assertNotNull(inputField, "Input field not found");


        // Step 4 (Ввести в строку pikabu.ru)
        screen.type("pikabu.ru");
        Match searchResult = foundElement(BrowserInterfaceLocators.searchResult);
        Assertions.assertNotNull(searchResult, "Tips not found");

        // Step 5 (Выбрать первый вариант и кликнуть на него мышью)
        screen.click(searchResult);
        Match installedPikabuApp = foundElement(BrowserInterfaceLocators.pikabuInstalled);
        Assertions.assertNotNull(installedPikabuApp, "App not installed");

        //Step 6 (Кликнуть на иконку приложения в боковой панели)
        Match pikabuApp = foundElement(BrowserInterfaceLocators.pikabuApp);
        screen.click(pikabuApp);
        Match pikabuAppOpened = foundElement(BrowserInterfaceLocators.pikabuAppOpened);
        Assertions.assertNotNull(pikabuAppOpened, "Pikabu app not opened");
    }

    @Test
    @SneakyThrows
    @DisplayName("Test case 2, step 7, VK login link")
    public void testAuthorizeWithVKID() {
        int startOpenedWindowCount = driver.getWindowHandles().size();
        openPikabuApp();
        scrollUp();
        Match loginWithVKID = foundElement(PikabuMiniAppLocators.loginWithVK);
        screen.click(loginWithVKID);
        int endOpenedWindowCount = driver.getWindowHandles().size();
        Assertions.assertEquals(startOpenedWindowCount, endOpenedWindowCount, "Link opened outside the app");
        closeWindowAfterTest();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test case 2, step 7, project side bar link")
    public void testNavigateToProjectSideBarLink() {
        int startOpenedWindowCount = driver.getWindowHandles().size();

        openPikabuApp();
        scrollUp();

        Match projectSideBarLink = foundElement(PikabuMiniAppLocators.sideBarPikabuProjectLink);
        screen.click(projectSideBarLink);

        int endOpenedWindowCount = driver.getWindowHandles().size();

        Assertions.assertEquals(startOpenedWindowCount, endOpenedWindowCount, "Link opened outside the app");
        closeWindowAfterTest();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test case 2, step 7, project footer link")
    public void testNavigateToProjectFooterLink() {
        int startOpenedWindowCount = driver.getWindowHandles().size();

        openPikabuApp();
        scrollDown();

        Match projectFooterLink = foundElement(PikabuMiniAppLocators.footerPikabuProjectLink);
        screen.click(projectFooterLink);

        int endOpenedWindowCount = driver.getWindowHandles().size();

        Assertions.assertEquals(startOpenedWindowCount, endOpenedWindowCount, "Link opened outside the app");
        closeWindowAfterTest();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test case 2, step 7, partners footer link")
    public void testNavigateToPartnersFooterLink() {
        int startOpenedWindowCount = driver.getWindowHandles().size();

        openPikabuApp();
        scrollDown();

        Match partnersFooterLink = foundElement(PikabuMiniAppLocators.footerPartnersPikabuLink);
        screen.click(partnersFooterLink);

        int endOpenedWindowCount = driver.getWindowHandles().size();

        Assertions.assertEquals(startOpenedWindowCount, endOpenedWindowCount, "Link opened outside the app");
        closeWindowAfterTest();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test case 2, step 7, partners sidebar link")
    public void testNavigateToPartnersSideBarLink() {
        int startOpenedWindowCount = driver.getWindowHandles().size();

        openPikabuApp();
        scrollUp();

        Match partnersSideBarLink = foundElement(PikabuMiniAppLocators.sideBarPartnersPikabuLink);
        screen.click(partnersSideBarLink);

        int endOpenedWindowCount = driver.getWindowHandles().size();

        Assertions.assertEquals(startOpenedWindowCount, endOpenedWindowCount, "Link opened outside the app");
        closeWindowAfterTest();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test case 2, step 7, VK group sidebar link")
    public void testNavigateToSideBarVKGroupLink() {
        int startOpenedWindowCount = driver.getWindowHandles().size();

        openPikabuApp();
        scrollDown();

        Match vkGroupLink = foundElement(PikabuMiniAppLocators.sideBarVKGroupLink);
        screen.click(vkGroupLink);

        int endOpenedWindowCount = driver.getWindowHandles().size();

        Assertions.assertEquals(startOpenedWindowCount, endOpenedWindowCount, "Link opened outside the app");
        closeWindowAfterTest();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test case 2, step 7, VK group footer link")
    public void testNavigateToFooterVKGroupLink() {
        int startOpenedWindowCount = driver.getWindowHandles().size();

        openPikabuApp();
        scrollDown();

        Match vkGroupLink = foundElement(PikabuMiniAppLocators.footerVKGroupLink);
        screen.click(vkGroupLink);

        int endOpenedWindowCount = driver.getWindowHandles().size();

        Assertions.assertEquals(startOpenedWindowCount, endOpenedWindowCount, "Link opened outside the app");
        closeWindowAfterTest();
    }

    @Test
    @SneakyThrows
    @DisplayName("Test case 3, steps 1-9")
    public void testWorkWithTabGroup() {

        SoftAssertions assertions = new SoftAssertions();

        // Step 1 (Запустить браузер и проверить элементи интерфейса с иконкой домика)
        Match startHomeElement = foundElement(BrowserInterfaceLocators.startHomeElement);
        assertions.assertThat(startHomeElement).withFailMessage("Home element not found").isNotNull();

        // Step 2 (Открыть любую вкладку)
        Match openNewTab = foundElement(BrowserInterfaceLocators.openNewTab);
        screen.click(openNewTab);

        Match openDzen = foundElement(BrowserInterfaceLocators.dzenWebsite);
        screen.click(openDzen);

        Match homePageCount = foundElement(BrowserInterfaceLocators.homePageCount);
        assertions.assertThat(homePageCount).withFailMessage("Home element count not changed").isNotNull();

        // Step 3 (Возле домика нажать на кнопку со стрелкой)
        Match arrowButton = foundElement(BrowserInterfaceLocators.homeArrowButton);
        screen.click(arrowButton);

        Match tabListMenu = foundElement(BrowserInterfaceLocators.tabListMenu);
        assertions.assertThat(tabListMenu).withFailMessage("Tab list menu not found").isNotNull();

        // Step 4 (Нажать на кнопку "Создать группу вкладок")
        Match makeNewTabGroup = foundElement(BrowserInterfaceLocators.makeNewTabGroup);
        screen.click(makeNewTabGroup);

        Match makeNewTabGroupBalloon = foundElement(BrowserInterfaceLocators.makeNewTabGroupBalloon);
        assertions.assertThat(makeNewTabGroupBalloon).withFailMessage("Balloon not found").isNotNull();

        // Step 5(Нажать на клавишу ESC)
        Match newTabGroup = foundElement(BrowserInterfaceLocators.newTabGroup);
        assertions.assertThat(newTabGroup).withFailMessage("New tab group making without accept").isNull();

        // Step 6 (Повторить создание новой группы вкладок, задав ей любое название, и нажать Enter в балуне ввода имени)
        Match arrowButton2 = foundElement(BrowserInterfaceLocators.homeArrowButton);
        screen.click(arrowButton2);

        Match makeNewTabGroup2 = foundElement(BrowserInterfaceLocators.makeNewTabGroup);
        screen.click(makeNewTabGroup2);
        screen.type("test");

        Match newTabGroupWithName = foundElement(BrowserInterfaceLocators.newTabGroupWithName);
        assertions.assertThat(newTabGroupWithName).withFailMessage("New tab group with accept not making").isNotNull();

        // Step 7 (Открыть в этой группе любую вкладку и проверить счётчик открытых вкладок у текущей и домашней группы)
        screen.click(openDzen);

        Match newTabGroupWithNameAndPage = foundElement(BrowserInterfaceLocators.newTabGroupWithNameAndPage);
        assertions.assertThat(homePageCount).withFailMessage("Home count changed").isNotNull();
        assertions.assertThat(newTabGroupWithNameAndPage).withFailMessage("Page count not changed").isNotNull();

        // Step 8 (Найти на странице любую ссылку и кликнуть по ней ПКМ. В меню навести курсор на опцию "Открыть ссылку в группе")
        Match randomLink = foundElement(BrowserInterfaceLocators.randomLink);
        screen.rightClick(randomLink);

        Match openLinkNewTab = foundElement(BrowserInterfaceLocators.openLinkNewTab);
        screen.hover(openLinkNewTab);

        Match currentGroup = foundElement(BrowserInterfaceLocators.test);
        Match homeGroup = foundElement(BrowserInterfaceLocators.home);
        assertions.assertThat(currentGroup).withFailMessage("current group not found").isNotNull();
        assertions.assertThat(homeGroup).withFailMessage("home group not found").isNotNull();

        // Step 9 (В этом меню выбрать открытие ссылки в другой группе отличной от текущей)
        Match otherGroup = foundElement(BrowserInterfaceLocators.existTabGroup);
        screen.click(otherGroup);

        Match otherPageCount = foundElement(BrowserInterfaceLocators.existTabGroupWithPage);
        assertions.assertThat(otherPageCount).withFailMessage("page count not changes").isNotNull();

        assertions.assertAll();
    }
}
