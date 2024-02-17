package pages.home;

import constans.Attribute;
import pages.base.BasePage;
import org.openqa.selenium.*;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
    private List<String> selectedProducts;
    private List<String> selectedPrices;

    private static class Card {
        private static final By lowerPriceLocator = By.xpath("//article/.//ins");
        private static final By productNameLocator = By.xpath("//span[@class='product-card__name']");
        private static final By btnAddToBasketLocator = By.xpath("//article/.//a[@href='/lk/basket']");
    }

    private static class Popup {
        private static final By btnLocator = By.xpath("//div[@class='popup__content']/ul/li");
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage addToBasket(int count) {
        List<WebElement> cardProductNames = driver.findElements(Card.productNameLocator);
        selectedProducts = cardProductNames.stream()
                .limit(count)
                .map(p -> p.getAttribute(Attribute.innerText.toString()).split("/")[1].trim())
                .collect(Collectors.toList());

        List<WebElement> cardLowerPrices = driver.findElements(Card.lowerPriceLocator);
        selectedPrices = cardLowerPrices.stream()
                .limit(count)
                .map(p -> p.getText().split("₽")[0].replaceAll("\\s", ""))
                .collect(Collectors.toList());

        driver.findElements(Card.btnAddToBasketLocator)
                .stream()
                .limit(count)
                .forEach(this::checkForPopup);
        return this;
    }

    private void checkForPopup(WebElement element) {
        element.click();
        try {
            driver.findElement(Popup.btnLocator).click();
        } catch (NoSuchElementException ignored) {
        }
    }

    public double getSumOfSelected() {
        return selectedPrices.stream().mapToDouble(Double::parseDouble).sum();
    }

    public int getCountOfSelected() {
        return selectedProducts.size();
    }

    public String getSelectedProductName(int index) {
        return selectedProducts.get(index);
    }

    public Double getSelectedProductPrice(int index) {
        return Double.parseDouble(selectedPrices.get(index));
    }
}
