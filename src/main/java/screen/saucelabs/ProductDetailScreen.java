package screen.saucelabs;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProductDetailScreen
{
    private ProductDetailScreen() {}

    private static final By ADD_TO_CART = byAttribute("text","Add To Cart");

    public void checkIfAddToCartButtonPresent()
    {
        $(ADD_TO_CART).as("Add to Cart").shouldHave(visible);
    }

}
