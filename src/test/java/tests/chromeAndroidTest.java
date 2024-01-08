package tests;

import base.TestSetup;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import providers.ChromeBrowserInAndroidAppProvider;
import java.time.Duration;
import static base.AppiumServer.start;
import static base.AppiumServer.stop;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;
import static utils.Util.switchFromNativeToWebContext;

public class chromeAndroidTest extends TestSetup
{
    private chromeAndroidTest () {}

    private static final By searchBox = By.id("com.android.chrome:id/search_box_text");

    @Description("Checking browser action on android app")
    @Test
    public void chromeAndroidTest ()
    {
        Configuration.browser = ChromeBrowserInAndroidAppProvider.class.getName();
        start();
        launchApp();
        switchFromNativeToWebContext();
        //open("https://qavbox.github.io/demo/");
        $(searchBox).shouldBe(visible, Duration.ofSeconds(10)).setValue("a");
        stop();

    }
}
