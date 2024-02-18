package wb;

import static wb.pages.ProductPage.productNames;
import static wb.pages.ProductPage.productPrices;

import jdk.jfr.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class BasketTest extends BaseTest {

    @Test
    @Description("Выбрать товары на главной странице и проверить их на соответствие в корзине")
    public void checkBasket1() {
        homePage
            .clickOnFirstCardProduct();
        productPage
            .selectSizeIfExist()
            .saveProductName()
            .saveProductPriceWithoutWbWallet()
            .addToBasket()
            .returnToHomePage();
        homePage
            .clickOnSecondCardProduct();
        productPage
            .selectSizeIfExist()
            .saveProductName()
            .saveProductPriceWithoutWbWallet()
            .addToBasket()
            .returnToHomePage();
        homePage
            .clickOnThirdCardProduct();
        productPage
            .selectSizeIfExist()
            .saveProductName()
            .saveProductPriceWithoutWbWallet()
            .addToBasket()
            .waitBasketBubbleEqualsThree()
            .goToBasket();

        Assertions.assertThat(basketPage.getProductNames()).containsAll(productNames);
        Assertions.assertThat(basketPage.getProductPrices()).containsAll(productPrices);
        Assertions.assertThat(basketPage.getTotalSum()).isEqualTo(productPage.getSumOfProductPrices());
    }
}