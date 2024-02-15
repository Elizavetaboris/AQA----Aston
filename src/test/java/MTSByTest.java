import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.Instant;
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
    @Test // тест на корректность надписей в незаполненных полях
    public void testEmptyCreditCardFields() {
        inputDataInForm();

        WebElement numCard = driver.findElement(By.xpath("//div[@class='content ng-tns-c47-1'][contains(.,'Номер карты')]"));
        Assert.assertEquals("Номер карты",numCard.getAttribute("textContent"));

        WebElement dateCard = driver.findElement(By.xpath("//div[@class='content ng-tns-c47-4'][contains(.,'Срок действия')]"));
        Assert.assertEquals("Срок действия", dateCard.getAttribute("textContent"));

        WebElement cvcCard = driver.findElement(By.xpath("//div[@class='content ng-tns-c47-5'][contains(.,'CVC')]"));
        Assert.assertEquals("CVC",cvcCard.getAttribute("textContent"));

        WebElement nameCard = driver.findElement(By.xpath("//div[@class='content ng-tns-c47-3'][contains(.,'Имя держателя (как на карте)')]"));
        Assert.assertEquals("Имя держателя (как на карте)",nameCard.getAttribute("textContent"));

        System.out.println("тест на корректность надписей в незаполненных полях для ввода реквизитов карты - пройден");
    }
    @Test  //тест на отображение суммы, номера и суммы на кнопке
    public void testPaymentDetails() {
        inputDataInForm();

        WebElement amountButton = driver.findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']"));
        String buttonText = amountButton.getText();
        Assert.assertEquals(buttonText, "Оплатить 200.00 BYN");

        WebElement amount = driver.findElement(By.xpath("//p[contains(@class,'header__payment-amount')]"));
        String text = amount.getText();
        Assert.assertEquals(text, "200.00 BYN");

        WebElement phoneNumber = driver.findElement(By.xpath("//p[contains(@class,'payment-info')]"));
        String text1 = phoneNumber.getText();
        Assert.assertEquals(text1, "Оплата: Услуги связи Номер:375297777777");
        System.out.println("тест на отображение суммы, суммы на кнопке и номера телефона - пройден");
    }
    @Test //тест на наличие иконок платежных систем
    public void test() {
        inputDataInForm();
        WebElement maestroCard = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        Assert.assertTrue(maestroCard.isDisplayed());

        WebElement visaIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        Assert.assertTrue(visaIcon.isDisplayed());

        WebElement belCard = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        Assert.assertTrue(belCard.isDisplayed());
        /*
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement mirIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']"));
        System.out.println("MirCard icon is displayed: " + mirIcon.isDisplayed());

        // Неявное ожидание для проверки наличия иконки для платежной системы Maestro
        WebElement maestroIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"));
        System.out.println("Maestro icon is displayed: " + maestroIcon.isDisplayed());
*/
    }
}

