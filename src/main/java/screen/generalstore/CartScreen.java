package screen.generalstore;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static org.openqa.selenium.By.xpath;

public class CartScreen
{
    private static final By PROCEED_BUTTON = xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnProceed\"]");

    public WebScreen ProceedWithPurchase() throws InterruptedException
    {
        $(PROCEED_BUTTON).as("Proceed Button").shouldBe(interactable).click(tap());
        Thread.sleep(5000);
        return screen(WebScreen.class);
    }
}
