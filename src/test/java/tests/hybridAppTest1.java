package tests;

import base.TestSetup;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import providers.GeneralStoreAndroidAppProvider;
import screen.generalstore.HomeScreen;

import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.launchApp;
import static enums.Product.CONVERSE_ALL_STAR;
import static enums.WebViews.WEBVIEW_IN_GENERALSTORE_APP;

public class hybridAppTest1 extends TestSetup
{
    private hybridAppTest1() {}

    @Description("checking hybrid app functionality in General Store android app")
    @Test
    public void hybridAppTest1() throws InterruptedException
    {
        Configuration.browser = GeneralStoreAndroidAppProvider.class.getName();
        launchApp();

        screen(HomeScreen.class)
             .fillDetailsInHomeScreen()
             .addProductToCart(CONVERSE_ALL_STAR)
             .ProceedWithPurchase()
             .WebInteraction(WEBVIEW_IN_GENERALSTORE_APP);
    }
}
