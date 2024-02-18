package wb.pages;

import static wb.locators.BasketPageLocators.basketProductNameLocator;
import static wb.locators.BasketPageLocators.basketProductPriceLocator;
import static wb.locators.BasketPageLocators.totalSumLocator;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {

  public List<String> getProductNames() {
    return driver.findElements(basketProductNameLocator)
        .stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  public List<String> getProductPrices() {
    waitUntilAnimationStop();

    return driver.findElements(basketProductPriceLocator)
        .stream()
        .map(element -> element
                .getText()
                .split("₽")[0]
                .replaceAll("\\s", "")
        )
        .collect(Collectors.toList());
  }

  public String getTotalSum() {
    return driver.findElement(totalSumLocator)
        .getText()
        .split("₽")[0]
        .replaceAll("\\s", "");
  }
}
