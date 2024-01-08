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

public class ChromeBrowserInAndroidAppProvider implements WebDriverProvider
{
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities)
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //Optional
        options.setPlatformVersion("11.0");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //Optional
        options.setDeviceName("Medium Phone API 30");
        //options.withBrowserName("Chrome");
        //options.setCapability("browserVersion","120.0.6099.199");
        //options.setChromedriverExecutable("120.0.6099.144");
        //options.setCapability("noReset", true);
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.autoGrantPermissions();

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
