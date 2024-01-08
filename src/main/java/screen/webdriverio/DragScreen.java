package screen.webdriverio;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static org.openqa.selenium.By.xpath;

public class DragScreen
{
    private static final String drag ="//android.view.ViewGroup[@content-desc='drag-%s']/android.widget.ImageView";
    private static final String drop = "//android.view.ViewGroup[@content-desc='drop-%s']/android.view.ViewGroup";

    public void solveDragDropPuzzle ()
    {
        for (int i = 1; i <= 3; i++)
        {
            for (char c : new char[]{'l', 'c', 'r'})
            {
                methodToPerformDragDrop(String.format("%c%d", c, i));
            }
        }
    }

    private void methodToPerformDragDrop(String value)
    {
        final SelenideAppiumElement DRAG = $(xpath(String.format(drag,value)));
        final SelenideAppiumElement DROP = $(xpath(String.format(drop,value)));
        DRAG.as("drag").dragAndDrop(to(DROP.as("drop")));
    }
}
