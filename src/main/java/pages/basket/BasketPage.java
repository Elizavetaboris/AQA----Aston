package pages.basket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends BasePage {
    private List<String> goodNames;
    private List<String> goodPrices;
    private static class ResultWindow {
        private static final By sumLocator = By
                .xpath("//span[text()='Итого']/following-sibling::span/span");
    }

    private static class Good {
        private static final By nameLocator = By.xpath("//span[@class='good-info__good-name']");
        private static final By priceLocator = By.xpath("//div[@class='list-item__price-new']");
    }

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public BasketPage readGoods() {
        goodNames = driver.findElements(Good.nameLocator)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        goodPrices = driver.findElements(Good.priceLocator)
                .stream()
                .map(p -> p.getText().split("₽")[0].replaceAll("\\s", ""))
                .collect(Collectors.toList());
        return this;
    }

    public double getGoodPrice(int index) {
        return Double.parseDouble(goodPrices.get(index));
    }

    public String getGoodName(int index) {
        return goodNames.get(index);
    }

    public int getCount() {
        return goodNames.size();
    }

    public double getSum() {
        return Double.parseDouble(driver.findElement(ResultWindow.sumLocator)
                .getText()
                .split("₽")[0]
                .replaceAll("\\s", ""));
    }

    public BasketPage wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
