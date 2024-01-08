package screen.webdriverio;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static enums.WebViews.WEBVIEW_IN_WEBDRIVERIO_APP;
import static utils.Util.switchFromNativeToWebContext;

public class HomeScreen
{
    private static final By WEB_VIEW = byText("Webview");
    private static final By SWIPE = byAttribute("content-desc","Swipe");
    private static final By DRAG = byAttribute("content-desc","Drag");
    private static final By LOGIN = byText("Login");

    public LeftMenu clickWebView ()
    {
        $(WEB_VIEW).as("WebView").shouldBe(visible).click(tap());
        switchFromNativeToWebContext(WEBVIEW_IN_WEBDRIVERIO_APP.getWebView());
        return screen(LeftMenu.class);
    }

    public void clickLoginButton()
    {
        $(LOGIN).as("Login Button").shouldBe(visible).click(tap());
    }

    public SwipeScreen clickSwipeButton()
    {
        $(SWIPE).as("Swipe Button").click(tap());
        return screen(SwipeScreen.class);
    }

    public DragScreen clickDragButton()
    {
        $(DRAG).as("Drag Button").click(tap());
        return screen(DragScreen.class);
    }
}
