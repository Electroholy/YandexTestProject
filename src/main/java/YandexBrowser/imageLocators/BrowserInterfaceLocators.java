package YandexBrowser.imageLocators;

import YandexBrowser.utils.Helper;
import org.sikuli.script.Pattern;

public class BrowserInterfaceLocators {

    private static final String mainPath = Helper.getValue("image.path");

    public static Pattern searchField = new Pattern(mainPath + "searchField.png");
    public static Pattern yandexMail = new Pattern(mainPath + "yandexmail.png");
    public static Pattern goBackButton = new Pattern(mainPath + "goBackButton.png");
    public static Pattern windowControlButton = new Pattern(mainPath + "windowControlButton.png");
    public static Pattern windowModeSwitchButton = new Pattern(mainPath + "windowModeSwitchButton.png");
    public static Pattern notFullScreenMailApp = new Pattern(mainPath + "notFullScreenMailApp.png");
    public static Pattern addAppButton = new Pattern(mainPath + "addAppButton.png");
    public static Pattern arrowToSideBalloon = new Pattern(mainPath + "arrowToSideBalloon.png");
    public static Pattern firstAppCategory = new Pattern(mainPath + "firstAppCategory.png");
    public static Pattern inputField = new Pattern(mainPath + "inputField.png");
    public static Pattern plusButtonSideBar = new Pattern(mainPath + "plusButtonSideBar.png");
    public static Pattern secondAppCategory = new Pattern(mainPath + "secondAppCategory.png");
    public static Pattern thirdAppCategory = new Pattern(mainPath + "thirdAppCategory.png");
    public static Pattern pikabuApp = new Pattern(mainPath + "pikabuApp.png");
    public static Pattern pikabuInstalled = new Pattern(mainPath + "pikabuInstalled.png");
    public static Pattern searchResult = new Pattern(mainPath + "searchResult.png");
    public static Pattern pikabuAppOpened = new Pattern(mainPath + "pikabuAppOpened.png");
    public static Pattern closeWindow = new Pattern(mainPath + "closeWindow.png");

    public static Pattern dzenWebsite = new Pattern(mainPath + "dzenWebsite.png");
    public static Pattern existTabGroup = new Pattern(mainPath + "existTabGroup.png");
    public static Pattern existTabGroupWithPage = new Pattern(mainPath + "existTabGroupWithPage.png");
    public static Pattern homeArrowButton = new Pattern(mainPath + "homeArrowButton.png");
    public static Pattern homePageCount = new Pattern(mainPath + "homePageCount.png");
    public static Pattern makeNewTabGroup = new Pattern(mainPath + "makeNewTabGroup.png");
    public static Pattern makeNewTabGroupBalloon = new Pattern(mainPath + "makeNewTabGroupBalloon.png");
    public static Pattern newTabGroup = new Pattern(mainPath + "newTabGroup.png");
    public static Pattern newTabGroupWithName = new Pattern(mainPath + "newTabGroupWithName.png");
    public static Pattern newTabGroupWithNameAndPage = new Pattern(mainPath + "newTabGroupWithNameAndPage.png");
    public static Pattern openLinkNewTab = new Pattern(mainPath + "openLinkNewTab.png");
    public static Pattern openNewTab = new Pattern(mainPath + "openNewTab.png");
    public static Pattern randomLink = new Pattern(mainPath + "randomLink.png");
    public static Pattern tabListMenu = new Pattern(mainPath + "tabListMenu.png");
    public static Pattern startHomeElement = new Pattern(mainPath + "startHomeElement.png");
    public static Pattern test = new Pattern(mainPath + "test");
    public static Pattern home = new Pattern(mainPath + "home");

}
