package wb.pages;

import static wb.locators.HomePageLocators.firstProductCardLocator;
import static wb.locators.HomePageLocators.secondProductCardLocator;
import static wb.locators.HomePageLocators.thirdProductCardLocator;

@SuppressWarnings("UnusedReturnValue")
public class HomePage extends BasePage {

    public HomePage clickOnFirstCardProduct() {
        waitVisibilityOfElement(driver.findElement(firstProductCardLocator)).click();
        return this;
    }

    public HomePage clickOnSecondCardProduct() {
        driver.findElement(secondProductCardLocator).click();
        return this;
    }

    public HomePage clickOnThirdCardProduct() {
        driver.findElement(thirdProductCardLocator).click();
        return this;
    }
}
