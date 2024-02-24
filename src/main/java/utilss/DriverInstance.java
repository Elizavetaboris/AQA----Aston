package utilss;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverInstance {
    private static DriverInstance instanceDriver;
    private static AndroidDriver<AndroidElement> driver;

    private DriverInstance() {
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        if (instanceDriver == null) {
            instanceDriver = new DriverInstance();
        }
        return instanceDriver.initialize();
    }

    public static void quit() {
        driver.quit();
        instanceDriver = null;
        driver = null;
    }

    private AndroidDriver<AndroidElement> initialize() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7 Pro API 34");
            capabilities.setCapability(MobileCapabilityType.APP, Constants.Urls.calcApk);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

            try {
                driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
        }
        return driver;
    }

}
