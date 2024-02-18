package wb.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class BaseWebDriver {

    private static WebDriver driver;


    public static void initDriver() {
        switch (ConfigurationProperties.getPlatformAndBrowser()) {
            case "win_chrome": WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "win_firefox": WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default: Assert.fail("Incorrent platform or browser name: " + ConfigurationProperties.getPlatformAndBrowser());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigurationProperties.getImplicitWait()));
    }

    public static void backToPreviousPage() {
      driver.navigate().back();
    }

    public static WebDriver getDriverInstance() {
        return driver;
    }

    public static void closeDriverInstance() {
        driver.close();
        driver.quit();
    }
}