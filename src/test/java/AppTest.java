import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest extends BaseTest{

    @Test
    public void testOnlinePayForm() {
        WebElement onlinePayFormText = getDriver().findElement(By.xpath("//section[@class='pay']/div[@class='pay__wrapper']/h2"));
        Assert.assertEquals(onlinePayFormText.getText(), "Онлайн пополнение\nбез комиссии");
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
        WebElement paySystemLogo = getDriver().findElement(By.xpath(paySystem1));
        Assert.assertEquals(paySystemLogo.getAttribute("alt"), paySystem);
    }
}
