package wb.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {

    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(
                Thread.currentThread().getContextClassLoader().getResource("configuration.properties").getPath());
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getPlatformAndBrowser() {
        return properties.getProperty("PLATFORM_AND_BROWSER");
    }

    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("IMPLICIT_WAIT"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("EXPLICIT_WAIT"));
    }

    public static String getWildberriesHomePage() {
        return properties.getProperty("WILDBERRIES_HOME_PAGE");
    }
}
