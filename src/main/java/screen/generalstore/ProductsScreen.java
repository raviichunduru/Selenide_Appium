package screen.generalstore;

import enums.Product;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static utils.Util.getProductLocator;

public class ProductsScreen
{
    private static final By SHOPPING_CART = byAttribute("resource-id","com.androidsample.generalstore:id/appbar_btn_cart");

    public CartScreen addProductToCart(Product Product)
    {
        final By ADD_PRODUCT_TO_CART = getProductLocator(Product);

        $(ADD_PRODUCT_TO_CART).as("Add product to Cart").scrollTo().shouldBe(enabled).click(tap());
        $(SHOPPING_CART).as("Shopping Cart").shouldBe(visible).click(tap());

        return screen(CartScreen.class);
    }
}
