package wb;

import wb.config.BaseWebDriver;
import wb.config.ConfigurationProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import wb.pages.BasketPage;
import wb.pages.HomePage;
import wb.pages.ProductPage;


abstract class BaseTest {

    static {
        BaseWebDriver.initDriver();
    }

    protected HomePage homePage = new HomePage();
    protected ProductPage productPage = new ProductPage();
    protected BasketPage basketPage = new BasketPage();

    @BeforeClass
    public void setUp() {
        BaseWebDriver.getDriverInstance().get(ConfigurationProperties.getWildberriesHomePage());
    }

    @AfterClass
    public void tearDown() {
        BaseWebDriver.closeDriverInstance();
    }
}

