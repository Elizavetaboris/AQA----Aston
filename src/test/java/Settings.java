import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Settings {
    protected WebDriver driver;

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