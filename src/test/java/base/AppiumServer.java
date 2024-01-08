package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.io.File;

public class AppiumServer
{
    static AppiumDriverLocalService server;

    private static void setInstance()
    {
        String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
        String nodeJSMainPath = "C:\\Users\\admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        String logPath = "C:\\Users\\admin\\IdeaProjects\\Selenide_Appium\\AppiumLogs\\log.txt";

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
            builder
              .withAppiumJS(new File(nodeJSMainPath))
              .usingDriverExecutable(new File(nodeExePath))
              .usingPort(4723)
              .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
              .withLogFile(new File(logPath))
              .withIPAddress("127.0.0.1");

            if(AppData.useGesturePlugin.contains("true"))
            {
              builder.withArgument(GeneralServerFlag.USE_PLUGINS, "gestures");
            }

            if(AppData.chromeAutoDownloadDriver.contains("true"))
            {
                builder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
            }

            server = AppiumDriverLocalService.buildService(builder);
    }

    private static AppiumDriverLocalService getInstance()
    {
      if(server == null)
       {
         setInstance();
       }
      return server;
    }

    public static void start()
    {
      getInstance().start();
      System.out.println(server.getUrl());
      System.out.println(server.isRunning());
    }

    public static void stop()
    {
      if(server != null)
       {
        getInstance().stop();
        System.out.println("Appium server stopped");
       }
    }
}
