package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.SauceLabAndroidAppProvider;
import screen.saucelabs.LeftMenuScreen;
import base.TestSetup;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class zoomTest extends TestSetup
{
    private zoomTest() {}

    @Description("checking zoom functionality")
    @Test
    public void zoomTest()
    {
        Configuration.browser = SauceLabAndroidAppProvider.class.getName();
        launchApp();

        screen(LeftMenuScreen.class)
                .zoomTest();

    }
}
