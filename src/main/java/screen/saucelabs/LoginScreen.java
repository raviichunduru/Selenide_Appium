package screen.saucelabs;

import entity.LoginDetails;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.AppiumSelectors.byContentDescription;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class LoginScreen
{
    private LoginScreen() {}

    private static final By OPENMENU = byContentDescription("open menu");
    private static final By LOGIN_LINK = byContentDescription("menu item log in");
    private static final By USERNAME = byContentDescription("Username input field");
    private static final By PASSWORD = byContentDescription("Password input field");
    private static final By LOGIN_BUTTON = byContentDescription("Login button");

    public HomeScreen LoginToApp(LoginDetails loginDetails)
    {
        $(OPENMENU).as("Open_Menu").shouldBe(visible).click(tap());
        $(LOGIN_LINK).as("Login link").shouldBe(visible).click(tap());
        $(USERNAME).as("User Name").shouldBe(visible).setValue(loginDetails.getUserName());
        $(PASSWORD).as("Password").shouldBe(visible).setValue(loginDetails.getPassword());
        $(LOGIN_BUTTON).as("Login button").shouldBe(enabled).click(tap());

        return screen(HomeScreen.class);
    }
}