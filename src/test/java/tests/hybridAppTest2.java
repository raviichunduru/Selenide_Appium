package tests;

import base.TestSetup;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.WebDriverIOAndroidAppProvider;
import screen.webdriverio.HomeScreen;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class hybridAppTest2 extends TestSetup
{
    private hybridAppTest2() {}

    @Description("Checking Hybrid App Functionality in Web Driver IO Android app")
    @Test
    public void hybridAppTest2 ()
    {
        Configuration.browser = WebDriverIOAndroidAppProvider.class.getName();
        launchApp();

        screen(HomeScreen.class)
                .clickWebView()
                .changeToDarkMode()
                .clickLoginButton();
    }
}
