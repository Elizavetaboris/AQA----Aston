package common;

import constans.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (Config.PLATFORM_AND_BROWSER) {
            case "win_chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "win_firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Incorrent platform or browser name: " + Config.PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.TimeoutVariable.IMPLICIT_WAIT));
        return driver;
    }
}