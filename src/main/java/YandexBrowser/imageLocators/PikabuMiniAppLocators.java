package YandexBrowser.imageLocators;

import YandexBrowser.utils.Helper;
import org.sikuli.script.Pattern;

public class PikabuMiniAppLocators {

    private static final String mainPath = Helper.getValue("image.path");

    public static Pattern loginWithVK = new Pattern(mainPath + "LoginWithVKID.png");
    public static Pattern sideBarPikabuProjectLink = new Pattern(mainPath + "sideBarPikabuProjectLink.png");
    public static Pattern footerPikabuProjectLink = new Pattern(mainPath + "pikabuProjectFooter.png");
    public static Pattern footerPartnersPikabuLink = new Pattern(mainPath + "partnersFooter.png");
    public static Pattern sideBarPartnersPikabuLink = new Pattern(mainPath + "partnersSideBar.png");
    public static Pattern footerVKGroupLink = new Pattern(mainPath + "VKgroupLinkFooter.png");
    public static Pattern sideBarVKGroupLink = new Pattern(mainPath + "VKgroupLinkSideBar.png");
}
