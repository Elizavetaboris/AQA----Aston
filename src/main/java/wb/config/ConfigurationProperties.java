package wb.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {
    public static String getPlatformAndBrowser() {
        return "win_chrome";
    }

    public static int getImplicitWait() {
        return 5;
    }

    public static int getExplicitWait() {
        return 5;
    }

    public static String getWildberriesHomePage() {
        return "https://www.wildberries.ru/";
    }

}