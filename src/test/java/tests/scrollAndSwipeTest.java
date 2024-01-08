package tests;

import base.TestSetup;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.WebDriverIOAndroidAppProvider;
import screen.webdriverio.HomeScreen;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class scrollAndSwipeTest extends TestSetup
{
    private scrollAndSwipeTest() {}

    @Description("Checking Vertical Swipe Functionality")
    @Test
    public void scrollAndSwipeTest()
    {
        Configuration.browser = WebDriverIOAndroidAppProvider.class.getName();
        launchApp();

        screen(HomeScreen.class)
                .clickSwipeButton()
                .scrollDown()
                .scrollUp()
                .swipeRight()
                .swipeLeft();
    }
}
