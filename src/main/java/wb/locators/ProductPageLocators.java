package wb.locators;

import org.openqa.selenium.By;

public class ProductPageLocators {

  public static By productNameLocator = (By.cssSelector(".product-page__title"));
  public static By tableSizeLocator = (By.cssSelector(".sizes-table__btn"));
  public static By sizeLocator = (By.cssSelector(".sizes-list__button"));
  public static By productPriceWithoutWbWalletLocator = (By.cssSelector(
      ".product-page__aside .price-block__final-price"));
  public static By addToBasketButtonLocator = (By.xpath(
      "//div[@class='product-page__aside']//button[@aria-label='Добавить в корзину']"));

}
