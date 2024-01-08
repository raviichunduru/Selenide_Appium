package base;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestSetup
{
    @BeforeAll
    static void setupAllureReports()
    {
     SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

    }

    //commented this because i am using multiple apps to run test cases
    /*@BeforeEach
    void setUp()
    {
        launchApp();
    }*/

    @AfterEach
    public void closeApp()
    {
        if (WebDriverRunner.getWebDriver() != null)
            WebDriverRunner.getWebDriver().quit();
    }

    @AfterAll
    static void tearDown()
    {
       SelenideLogger.removeListener("AllureSelenide");
    }
}
