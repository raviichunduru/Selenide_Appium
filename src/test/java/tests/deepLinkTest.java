package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.SauceLabAndroidAppProvider;
import base.TestSetup;

import static com.codeborne.selenide.appium.SelenideAppium.launchApp;
import static com.codeborne.selenide.appium.SelenideAppium.openAndroidDeepLink;

public class deepLinkTest extends TestSetup
{
    private deepLinkTest() {}

    @Description("checking deep link functionality")
    @Test
    public void deepLinkTet()
    {
        Configuration.browser = SauceLabAndroidAppProvider.class.getName();
        launchApp();

        openAndroidDeepLink("mydemoapprn://product-details/1","com.saucelabs.mydemoapp.rn");
    }
}
