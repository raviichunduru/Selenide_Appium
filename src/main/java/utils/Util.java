package utils;

import com.codeborne.selenide.appium.AppiumDriverRunner;
import enums.Product;
import org.openqa.selenium.By;

import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class Util
{
    public static void switchFromNativeToWebContext (String webView)
    {
        boolean isWebViewContextFound = false;

        Set<String> contextHandles = AppiumDriverRunner.getAndroidDriver().getContextHandles();
        for (String context:contextHandles)
        {
            if(context.equalsIgnoreCase(webView))
            {
                AppiumDriverRunner.getAndroidDriver().context(webView);
                isWebViewContextFound = true;
                break;
            }
        }
        if(!isWebViewContextFound)
            System.out.println("Web Context not available");
    }

    public static void switchFromNativeToWebContext ()
    {
        System.out.println("AppiumDriverRunner.getAndroidDriver().getContext() = " + AppiumDriverRunner.getAndroidDriver().getContext());
        System.out.println("AppiumDriverRunner.getAndroidDriver().getContextHandles() = " + AppiumDriverRunner.getAndroidDriver().getContextHandles());

        Set<String> contextHandles = AppiumDriverRunner.getAndroidDriver().getContextHandles();
        AppiumDriverRunner.getAndroidDriver().context((String) contextHandles.toArray()[1]);

        System.out.println("AppiumDriverRunner.getAndroidDriver().getContext() = " + AppiumDriverRunner.getAndroidDriver().getContext());
    }

    public static void switchFromWebToNativeContext ()
    {
        AppiumDriverRunner.getAndroidDriver().context("NATIVE_APP");
    }

    public static String getXpath(String xpath, String value)
    {
        return String.format(xpath, value);
    }

    public static By getProductLocator(Product p)
    {
        return xpath(getXpath("//*[@text='%s']/following-sibling::android.widget.LinearLayout[2]//android.widget.TextView[@text='ADD TO CART']", p.getProduct()));
    }


}
