package wb.pages;

import wb.config.BaseWebDriver;
import wb.config.ConfigurationProperties;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

  public WebDriver driver = BaseWebDriver.getDriverInstance();

  private final WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(
      ConfigurationProperties.getExplicitWait()));


  public WebElement waitVisibilityOfElement(WebElement element) {
    return webDriverWait.until(ExpectedConditions.visibilityOf(element));
  }

  public void waitTextToBe(By element, String text) {
    webDriverWait.until(ExpectedConditions.textToBe(element, text));
  }

  public static void waitUntilAnimationStop() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

