package providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class APIDemosAndroidAppProvider implements WebDriverProvider
{
    @Nonnull
    @Override
    public  WebDriver createDriver(@Nonnull Capabilities capabilities)
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //Optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //Optional
        options.setDeviceName("Medium Phone API 30");
        //options.setCapability("noReset", true);
        //options.setApp(System.getProperty("user.dir")+"/Apps/ApiDemos-debug.apk");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");

        try
        {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
        }

        catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
