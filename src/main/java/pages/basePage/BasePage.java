package pages.basePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilss.DriverInstance;

public class BasePage {
    protected AndroidDriver<AndroidElement> driver = DriverInstance.getDriver();
}