package screen.saucelabs;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class HomeScreen
{
    private HomeScreen () {}

    private static final By PRODUCT = byAttribute("text","Sauce Labs Backpack");
    private static final By COPYRIGHT = byAttribute("text","© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.");
    private static String copyrightText = "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.";

    public ProductDetailScreen clickProduct()
    {
        $(PRODUCT).as("Product").shouldBe(visible).click(tap());
        return screen(ProductDetailScreen.class);
    }

    public void checkIfCopyrightPresent()
    {
        $(COPYRIGHT).as("Copyright").scrollTo().shouldBe(visible).shouldHave(exactText(copyrightText));
    }
}
