package screen.apidemo;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumClickOptions.longPress;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class APIDemos
{
    private APIDemos () {}

    private static final By VIEWS = byAttribute("text","Views");
    private static final By EXPANDED_LISTS = byAttribute("text","Expandable Lists");
    private static final By CUSTOM_ADAPTER = byAttribute("text","1. Custom Adapter");
    private static final By PEOPLE_NAMES = byAttribute("text","People Names");
    private static final By SAMPLE_ACTION = byAttribute("text","Sample action");

    private static final By DRAG_DROP = byAttribute("text","Drag and Drop");
    private static final SelenideElement sourceElement =  $(Selectors.byId("io.appium.android.apis:id/drag_dot_1"));
    private static final SelenideElement destinationElement =  $(Selectors.byId("io.appium.android.apis:id/drag_dot_2"));
    private static final By dragDropResult = AppiumBy.id("io.appium.android.apis:id/drag_result_text");

    public void longPressTest()
    {
        $(VIEWS).as("Views").shouldBe(visible).click(tap());
        $(EXPANDED_LISTS).as("Expandable Lists").shouldBe(visible).click(tap());
        $(CUSTOM_ADAPTER).as("Custom Adapter").shouldBe(visible).click(tap());
        $(PEOPLE_NAMES).as("People Names").shouldBe(visible).click(longPress());
        $(SAMPLE_ACTION).as("Sample Action").shouldHave(visible);
    }

    public void dragDropTest()
    {
        $(VIEWS).as("Views").shouldBe(visible).click(tap());
        $(DRAG_DROP).as("Drag and Drop").shouldBe(visible).click(tap());
        sourceElement.as("Source Element").dragAndDrop(to(destinationElement.as("Destination Element")));
        $(dragDropResult).as("Drop drop result").shouldHave(text("Dropped!"));
    }
}
