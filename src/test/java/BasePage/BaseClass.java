package BasePage;

import Hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;


    public BaseClass() {
        this.driver = Hooks.driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //public WebDriverWait waitForElement(WebElement element, int timeoutInSeconds) {
    //  return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    // }

    public void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        // wait.until(driver -> element.isDisplayed() && element.isEnabled());
        // element.click();
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }
}

