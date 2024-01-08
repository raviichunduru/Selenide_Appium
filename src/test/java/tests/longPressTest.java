package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.APIDemosAndroidAppProvider;
import screen.apidemo.APIDemos;
import base.TestSetup;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class longPressTest extends TestSetup
{
    private longPressTest() {}

    @Description("checking long press functionality")
    @Test
    public void longPressTest()
    {
        Configuration.browser = APIDemosAndroidAppProvider.class.getName();
        launchApp();

        screen(APIDemos.class)
                .longPressTest();
    }
}