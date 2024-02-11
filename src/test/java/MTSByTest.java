import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.sound.midi.Soundbank;
import java.time.Duration;

public class MTSByTest extends Settings {
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
    @Test
    public void testOnlinePaymentForServices() throws InterruptedException {

        WebElement selectNow = driver.findElement(By.xpath("//button[contains(.,'Услуги связи')]"));
        // Заполнение полей с реквизитами
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        phoneNumberInput.sendKeys("(29)777-77-77");
        System.out.println("тест ввод номера пройден");

        WebElement amountInput = driver.findElement(By.xpath("(//input[@placeholder='Сумма'])[1]"));
        amountInput.sendKeys("200");
        System.out.println("тест ввод суммы пройден");

        // Нажатие кнопки "Продолжить"
        WebElement continueButton = driver.findElement(By.xpath("(//button[contains(.,'Продолжить')])[1]"));
        continueButton.click();
        System.out.println("тест кнопка пройден");
        Thread.sleep(8000);

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(frameElement);

        // тесты на корректность надписей в незаполненных полях
        WebElement numCard = driver.findElement(By.xpath("(//div[contains(.,'Номер карты')])[9]"));
        Assert.assertEquals("Номер карты",numCard.getAttribute("textContent"));

        WebElement dateCard = driver.findElement(By.xpath("(//div[contains(.,'Срок действия')])[10]"));
        Assert.assertEquals("Срок действия", dateCard.getAttribute("textContent"));

        WebElement cvcCard = driver.findElement(By.xpath("(//div[contains(.,'CVC')])[10]"));
        Assert.assertEquals("CVC",cvcCard.getAttribute("textContent"));

        WebElement nameCard = driver.findElement(By.xpath("(//div[contains(.,'Имя держателя (как на карте)')])[9]"));
        Assert.assertEquals("Имя держателя (как на карте)",nameCard.getAttribute("textContent"));
        System.out.println("тест на корректность надписей в незаполненных полях для ввода реквизитов карты - пройден");

        //тесты на отображение суммы и номера
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


        //тесты на наличие иконок платежных систем
        WebElement visaIcon = driver.findElement(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']"));
        Assert.assertTrue(visaIcon.isDisplayed());

        WebElement belCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']"));
        Assert.assertTrue(belCard.isDisplayed());

        WebElement maestroCard = driver.findElement(By.xpath("(//img[@class='ng-tns-c53-0 ng-star-inserted'])[1]"));
        Assert.assertTrue(maestroCard.isDisplayed());

        WebElement mirCard = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"));
        Assert.assertTrue(mirCard.isDisplayed());
        System.out.println("тест на наличие иконок платёжных систем - пройден");
        }
    }

