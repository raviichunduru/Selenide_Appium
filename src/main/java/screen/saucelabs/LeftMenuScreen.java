package screen.saucelabs;

import com.codeborne.selenide.appium.AppiumDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.AppiumSelectors.byContentDescription;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class LeftMenuScreen
{
    private LeftMenuScreen () {}

    private static final By OPENMENU = byContentDescription("open menu");
    private static final By DRAWING_LINK = byContentDescription("menu item drawing");
    private static final By DRAWING_SCREEN = byContentDescription("drawing screen");

    public void zoomTest()
    {
        $(OPENMENU).as("Open Menu").shouldBe(visible).click(tap());
        $(DRAWING_LINK).as("Drawing Link").shouldBe(visible).click(tap());
        $(DRAWING_SCREEN).as("DRAWING SCREEN").shouldBe(visible);

        Point centerOfElement = getCentreOfElement($(DRAWING_SCREEN));

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence1 = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(300)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),centerOfElement.getX()+400, centerOfElement.getY()-400))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH,"finger2");
        Sequence sequence2 = new Sequence(finger2,1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2,Duration.ofMillis(300)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(),centerOfElement.getX()-400, centerOfElement.getY()+400))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        AppiumDriverRunner.getAndroidDriver().perform(Arrays.asList(sequence1,sequence2));
    }

    private Point getCentreOfElement(WebElement element)
    {
        Point point = element.getLocation();
        Dimension size = element.getSize();
        return new Point(point.getX()+(size.getWidth()/2), point.getY()+(size.height/2));
    }
}
