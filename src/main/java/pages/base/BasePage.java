package pages.base;

import constans.Attribute;
import constans.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

    public class BasePage {
        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }

        public void open(String url) {
            driver.get(url);
        }

        public WebElement waitVisibilityOfElement(WebElement element, int seconds) {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOf(element));
            return element;
        }

        public WebElement waitAttributeToBe(WebElement element, Attribute attribute, String value) {
            new WebDriverWait(driver, Duration.ofSeconds(Constant.TimeoutVariable.EXPLICIT_WAIT))
                    .until(ExpectedConditions.attributeToBe(element, attribute.toString(), value));
            return element;
        }
    }

