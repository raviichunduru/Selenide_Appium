package screen.generalstore;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.AppiumSelectors.byAttribute;
import static com.codeborne.selenide.appium.ScreenObject.screen;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class HomeScreen
{
    private static final By COUNTRY = byAttribute("resource-id","com.androidsample.generalstore:id/spinnerCountry");
    private static final By CHINA = byAttribute("text","China");
    private static final By NAME = byAttribute("resource-id","com.androidsample.generalstore:id/nameField");
    private static final By GENDER = byAttribute("resource-id","com.androidsample.generalstore:id/radioFemale");
    private static final By LETS_SHOP_BUTTON = byAttribute("resource-id","com.androidsample.generalstore:id/btnLetsShop");

    public ProductsScreen fillDetailsInHomeScreen()
    {
        //$(COUNTRY).as("Country").shouldBe(visible).click(tap());
        //$(CHINA).as("China").scrollTo().click(tap());
        $(NAME).as("Name").shouldBe(visible).setValue("Ravi");
        //$(GENDER).as("Gender").shouldBe(visible).click(tap());
        $(LETS_SHOP_BUTTON).as("Lets Shop Button").shouldBe(visible).click(tap());

        return screen(ProductsScreen.class);
    }
}