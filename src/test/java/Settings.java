import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Settings {
    protected WebDriver driver;
    public static final long IMPLICITLY_WAIT = 10;
    public static final long PAGE_LOAD_TIMEOUT = 10;
    public static final long SCRIPT_RUN_TIMEOUT = 10;

    public WebDriver getDriver(){
        return driver;
    }
    public WebDriver createDriver() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(SCRIPT_RUN_TIMEOUT, TimeUnit.SECONDS);
        return driver;

    }
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
    }
   @AfterClass
   public void tearDown () {
            if (driver != null) {
                driver.quit();

            }
        }
    }