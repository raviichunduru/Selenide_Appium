package screen.generalstore;

import com.codeborne.selenide.appium.AppiumDriverRunner;
import enums.WebViews;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static utils.Util.switchFromNativeToWebContext;

public class WebScreen
{
    private static final By SEARCH = By.xpath("//textarea[@name='q']");
    private static final By SEARCH_RESULT = By.xpath("//span[text()='Google']");

    public static void WebInteraction(WebViews webView)
    {
        System.out.println("AppiumDriverRunner.getAndroidDriver().getContext() = " + AppiumDriverRunner.getAndroidDriver().getContext());
        System.out.println("AppiumDriverRunner.getAndroidDriver().getContextHandles() = " + AppiumDriverRunner.getAndroidDriver().getContextHandles());

        switchFromNativeToWebContext(webView.getWebView());
        System.out.println("AppiumDriverRunner.getAndroidDriver().getContext() = " + AppiumDriverRunner.getAndroidDriver().getContext());
        //switchFromNativeToWebContext();

        $(SEARCH).as("Search").shouldBe(visible).setValue("Google").pressEnter();
        $$(SEARCH_RESULT).as("Search Result").shouldHave(size(3))
                                                   .shouldHave(containExactTextsCaseSensitive("Google", "Google", "Google"));

        AppiumDriverRunner.getAndroidDriver().pressKey(new KeyEvent(AndroidKey.BACK));

    }
}
