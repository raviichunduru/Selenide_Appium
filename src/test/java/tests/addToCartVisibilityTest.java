package tests;

import base.TestSetup;
import com.codeborne.selenide.Configuration;
import entity.LoginDetails;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.SauceLabAndroidAppProvider;
import screen.saucelabs.LoginScreen;
import testdata.LoginTestData;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;

public class addToCartVisibilityTest extends TestSetup
{
    private addToCartVisibilityTest() {}

    private final LoginDetails loginDetails = LoginTestData.getLogindetails();

    @Description("checking addtocart button visibility")
    @Test
    public void addToCartVisibilityTest()
    {
        Configuration.browser = SauceLabAndroidAppProvider.class.getName();
        launchApp();

        screen(LoginScreen.class)
                .LoginToApp(loginDetails)
                .clickProduct()
                .checkIfAddToCartButtonPresent();
    }
}
