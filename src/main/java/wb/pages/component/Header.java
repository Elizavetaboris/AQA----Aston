package wb.pages.component;

import wb.config.BaseWebDriver;
import org.openqa.selenium.WebDriver;
import wb.pages.BasePage;
import wb.locators.HeaderLocators;

public class Header extends BasePage {

    public WebDriver driver = BaseWebDriver.getDriverInstance();


    public Header clickOnBasket() {
        driver.findElement(HeaderLocators.basketButtonLocator).click();
        return this;
    }

    public void waitBasketBubbleEqualsThree() {
        waitTextToBe(HeaderLocators.basketBubbleLocator, "3");
    }

}
