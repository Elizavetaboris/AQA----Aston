package wb.pages;

import wb.config.BaseWebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import wb.pages.component.Header;
import wb.locators.ProductPageLocators;

public class ProductPage extends BasePage {

  private final Header header = new Header();

  public static List<String> productNames = new ArrayList<>();
  public static List<String> productPrices = new ArrayList<>();


  public ProductPage saveProductName() {
    productNames.add(driver.findElement(ProductPageLocators.productNameLocator).getText());
    return this;
  }

  public ProductPage saveProductPriceWithoutWbWallet() {
    productPrices.add(driver.findElement(ProductPageLocators.productPriceWithoutWbWalletLocator).getText()
        .split("₽")[0]
        .replaceAll("\\s", ""));
    return this;
  }

  public ProductPage selectSizeIfExist() {
    try {
      WebElement sizeTable = driver.findElement(ProductPageLocators.tableSizeLocator);
      if (sizeTable.isDisplayed() && sizeTable.getText().equals("Таблица размеров")) {
        driver.findElements(ProductPageLocators.sizeLocator)
            .stream()
            .filter(WebElement::isEnabled)
            .collect(Collectors.toList())
            .get(0)
            .click();
      }
    } catch (Exception e) {
      return this;
    }
    return this;
  }

  public ProductPage addToBasket() {
    driver.findElement(ProductPageLocators.addToBasketButtonLocator).click();
    return this;
  }

  public ProductPage waitBasketBubbleEqualsThree() {
    header.waitBasketBubbleEqualsThree();
    return this;
  }

  public ProductPage goToBasket() {
    header.clickOnBasket();
    return this;
  }

  public ProductPage returnToHomePage() {
    BaseWebDriver.backToPreviousPage();
    return this;
  }

  public String getSumOfProductPrices() {
    return String.valueOf(
        productPrices.stream()
            .mapToInt(Integer::parseInt)
            .sum());
  }

}
