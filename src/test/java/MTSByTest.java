import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MTSByTest extends Settings {
    private final String phone = "297777777";
    private final String paySum = "200";
    private final String email = "Eli-Krivonosova@yandex.ru";

    @DataProvider(name = "onlinePayForms")
    public Object[][] paymentOptions() {
        return new Object[][]{
                {"Услуги связи", "Номер телефона", "Сумма", "E-mail для отправки чека"},
                {"Домашний интернет", "Номер абонента", "Сумма", "E-mail для отправки чека"},
                {"Рассрочка", "Номер счета на 44", "Сумма", "E-mail для отправки чека"},
                {"Задолженность", "Номер счета на 2073", "Сумма", "E-mail для отправки чека"}};
    }

    @Test(dataProvider = "onlinePayForms")
    public void testOnlinePayForms(String payment, String placeholder1, String placeholder2, String placeholder3) {
        getDriver().findElement(By.xpath("//div[@class='pay__form']//div[@class='select__wrapper']")).click();
        getDriver().findElement(By.xpath(String.format("//div[@class='pay__form']//p[contains(text(), '%s')]", payment))).click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getDriver().findElement(By.xpath("//form[@class='pay-form opened']/div[1]/input")).getAttribute("placeholder"), placeholder1);
        softAssert.assertEquals(getDriver().findElement(By.xpath("//form[@class='pay-form opened']/div[2]/input")).getAttribute("placeholder"), placeholder2);
        softAssert.assertEquals(getDriver().findElement(By.xpath("//form[@class='pay-form opened']/div[3]/input")).getAttribute("placeholder"), placeholder3);
        softAssert.assertAll();
    }
    public void inputDataInForm() {
        driver.findElement(By.xpath("//input[@id='connection-phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='connection-sum']")).sendKeys(paySum);
        driver.findElement(By.xpath("//input[@id='connection-email']")).sendKeys(email);
        System.out.println("Данные введены");
        driver.findElement(By.xpath("//form[@id='pay-connection']/button")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frameElement);
    }
    @Test // корректность отображения суммы, номера телефона
    public void testOnlinePayDetailsOnHeader() {
        inputDataInForm();
        WebElement paymentDetails = new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-payment-container/app-header")));
        Assert.assertEquals(paymentDetails.getText(), String.format("%s.00 BYN\nОплата: Услуги связи Номер:375%s", paySum, phone));
    }

    @Test //корректность отображения суммы (на кнопке)
    public void testOnlinePaySummOnButton() {
        inputDataInForm();
        WebElement paymentDetails = new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-page__card']/button")));
        Assert.assertEquals(paymentDetails.getText(), String.format("Оплатить %s.00 BYN", paySum));
    }

    @Test // тест на корректность надписей в незаполненных полях
    public void testEmptyCreditCardFields() {
        inputDataInForm();

        WebElement numCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-1 ng-star-inserted']"));
        Assert.assertEquals("Номер карты", numCard.getAttribute("textContent"));

        WebElement dateCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']"));
        Assert.assertEquals("Срок действия", dateCard.getAttribute("textContent"));

        WebElement cvcCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-5 ng-star-inserted']"));
        Assert.assertEquals("CVC", cvcCard.getAttribute("textContent"));

        WebElement nameCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']"));
        Assert.assertEquals("Имя держателя (как на карте)", nameCard.getAttribute("textContent"));
    }


    @Test //тест на наличие иконок платежных система наличи
    public void testPaymentIcons() {
        inputDataInForm();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5));

        WebElement masterCard = wait.withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']")));
        Assert.assertTrue(masterCard.isDisplayed());

        WebElement visaIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']")));
        Assert.assertTrue(visaIcon.isDisplayed());


        WebElement belCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']")));
        Assert.assertTrue(belCard.isDisplayed());


        WebElement mirIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system.svg']")));
        Assert.assertTrue(mirIcon.isDisplayed(), "Мир icon is not displayed");

        // повторно ищем и проверяем иконку "маэстро"
        WebElement maestroIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']")));
        Assert.assertTrue(maestroIcon.isDisplayed(), "Maestro icon is not displayed");

    }
}

