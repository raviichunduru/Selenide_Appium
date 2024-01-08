package Suites;

import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({addToCartVisibilityTest.class, checkCopyRightTest.class, deepLinkTest.class, dragDropTest.class, longPressTest.class,
                     zoomTest.class, hybridAppTest1.class, hybridAppTest2.class, scrollAndSwipeTest.class, dragDropPuzzle.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSuite
{
   /* @BeforeAll
    static void setupSuite()
    {
    AppiumServer.start();
    }

    @AfterAll
    static void teardownSuite()
    {
        AppiumServer.stop();
    }*/
}
