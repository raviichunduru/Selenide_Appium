package screen.webdriverio;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static org.openqa.selenium.By.xpath;
import static utils.Util.switchFromWebToNativeContext;

public class LeftMenu
{
    private static final By HAMBURG = xpath("//button[@class='navbar__toggle clean-btn']");
    private static final By DARK_MODE = xpath("//div[@class='toggle_vylO margin-right--md']//button[@class='clean-btn toggleButton_gllP']");

    public HomeScreen changeToDarkMode ()
    {
        $(HAMBURG).as("Hamburg").shouldBe(visible).click(tap());
        $(DARK_MODE).as("Dark Mode").shouldBe(visible).click(tap());
        switchFromWebToNativeContext();
        return screen(HomeScreen.class);
    }

}
