package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;
import common.Config;
import common.CommonActions;
import elements.base.BaseElement;
import elements.header.Header;
import pages.base.BasePage;
import pages.basket.BasketPage;
import pages.home.HomePage;


public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = PageFactory.initElements(driver, BasePage.class);
    protected HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    protected BasketPage basketPage = PageFactory.initElements(driver, BasketPage.class);
    protected BaseElement baseElement = PageFactory.initElements(driver, BaseElement.class);
    protected Header header = PageFactory.initElements(driver, Header.class);
    protected SoftAssert softAssert = new SoftAssert();

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (Config.QUIT_BROWSER) {
            driver.quit();
        }
    }
}
