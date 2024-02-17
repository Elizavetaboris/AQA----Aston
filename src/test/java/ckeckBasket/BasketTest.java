package ckeckBasket;

import jdk.jfr.Description;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constans.Constant.Urls.WILDBERRIES_HOME_PAGE;


public class BasketTest extends BaseTest {
    @Test
    @Description("Выбрать товары на главной странице и проверить их на соответствие в корзине")
    public void checkBasket() {
        final int COUNT = 3;
        basePage.open(WILDBERRIES_HOME_PAGE);
        homePage.addToBasket(COUNT);
        header.clickBasketButton();
        basketPage.wait(1500).readGoods();

        Assert.assertEquals(basketPage.getCount(), homePage.getCountOfSelected(), "Different counts");
        for (int i = 0; i < COUNT; i++) {
            softAssert.assertEquals(
                    basketPage.getGoodName(COUNT - i - 1),
                    homePage.getSelectedProductName(i),
                    "Different names"
            );
            softAssert.assertEquals(
                    basketPage.getGoodPrice(COUNT - i - 1),
                    homePage.getSelectedProductPrice(i),
                    "Different prices"
            );
        }
        softAssert.assertEquals(basketPage.getSum(), homePage.getSumOfSelected(), "Different sums");
        softAssert.assertAll();
    }
}