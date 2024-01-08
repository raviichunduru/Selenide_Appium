package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.SauceLabAndroidAppProvider;
import screen.saucelabs.HomeScreen;
import base.TestSetup;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class checkCopyRightTest extends TestSetup
{
    private checkCopyRightTest() {}

    @Description("checking copy right text")
    @Test
    public void checkCopyRightTest()
    {
        Configuration.browser = SauceLabAndroidAppProvider.class.getName();
        launchApp();

        screen(HomeScreen.class)
                .checkIfCopyrightPresent();
    }
}
