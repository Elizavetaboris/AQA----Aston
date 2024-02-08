import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MTSByTest extends Settings {

    @Test
    public void checkLink() {
        driver.findElement(By.xpath("//a[contains(.,'Подробнее о сервисе')]")).click();
        // Возвращаемся на предыдущую страницу
        driver.navigate().back();
    }
    @DataProvider(name = "paySystems")
    public String[][] factorials() {
        return new String[][] {
                { "Visa" },
                { "Verified By Visa" },
                { "MasterCard" },
                { "MasterCard Secure Code" },
                { "Белкарт" },
                { "МИР" }
        };
    }
    @Test(dataProvider = "paySystems")
    public void testPaySystemLogo(String paySystem) {
        String paySystem1 = String.format("//div[@class='pay__partners']/ul/li/img[@alt = '%s']", paySystem);
        System.out.println(paySystem1);
        WebElement paySystemLogo = driver.findElement(By.xpath(paySystem1));
        Assert.assertEquals(paySystemLogo.getAttribute("alt"), paySystem);
    }
    @Test
    public void testOnlinePayForm() {
         WebElement onlinePayFormText = driver.findElement(By.xpath("//h2[contains(.,'Онлайн пополнение без комиссии')]"));
         Assert.assertEquals(onlinePayFormText.getText(), "Онлайн пополнение\nбез комиссии");
        }
    @Test
    public void checkButtons() {
         WebElement selectNow = driver.findElement(By.xpath("//button[contains(.,'Услуги связи')]"));

         WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
         phoneNumberInput.sendKeys("297777777");

         WebElement continueButton = driver.findElement(By.xpath("(//button[contains(.,'Продолжить')])[1]"));
         continueButton.click();
        }
    }
