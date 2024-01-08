package screen.webdriverio;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.appium.AppiumScrollOptions.down;
import static com.codeborne.selenide.appium.AppiumScrollOptions.up;
import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;
import static com.codeborne.selenide.appium.AppiumSwipeOptions.left;
import static com.codeborne.selenide.appium.AppiumSwipeOptions.right;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class SwipeScreen
{
    private static final By WEBDRIVER_LOGO = byAttribute("content-desc","WebdriverIO logo");
    private static final By SWIPE_HORIZENTAL_TEXT = byAttribute("text","Swipe horizontal");
    private static final By RIGHT_MOST_ELEMENT = byXpath("(//android.view.ViewGroup[@content-desc=\"card\"])[6]");
    private static final By LEFT_MOST_ELEMENT = byXpath("(//android.view.ViewGroup[@content-desc=\"card\"])[6]");

    public SwipeScreen scrollDown()
    {
        $(WEBDRIVER_LOGO).scroll(down()).shouldBe(visible);
        return screen(SwipeScreen.class);
    }

    public SwipeScreen scrollUp()
    {
        $(SWIPE_HORIZENTAL_TEXT).scroll(up()).shouldBe(visible);
        return screen(SwipeScreen.class);
    }

    public SwipeScreen swipeRight()
    {
        $(RIGHT_MOST_ELEMENT).swipe(right());
        return screen(SwipeScreen.class);
    }

    public void swipeLeft()
    {
        $(LEFT_MOST_ELEMENT).swipe(left());
    }
}
