package tests;

import base.TestSetup;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.WebDriverIOAndroidAppProvider;
import screen.webdriverio.HomeScreen;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class dragDropPuzzle extends TestSetup
{
    private dragDropPuzzle() {}

    @Description("Solving drag and drop puzzle")
    @Test
    public void dragDropPuzzle()
    {
        Configuration.browser = WebDriverIOAndroidAppProvider.class.getName();
        launchApp();

        screen(HomeScreen.class)
                .clickDragButton()
                .solveDragDropPuzzle();

    }
}
