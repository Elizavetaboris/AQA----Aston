package baseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilss.DriverInstance;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {
    protected static AndroidDriver<AndroidElement> driver;

    @BeforeAll
    public static void setup() {
        driver = DriverInstance.getDriver();
    }

    @AfterAll
    public static void teardown() {
        DriverInstance.quit();
    }
}
