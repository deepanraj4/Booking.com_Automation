package pageobjects;


import BasePage.BaseClass;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BaseClass
{

    public final WebDriver driver;
    public final WebDriverWait wait;

    public static final String SEARCH_BOX = "//*[@id='searchbox-horizontal-destination-input']";
    public static final String SELECT_DATE_FIELD = "//*[@id=\"SearchBoxDesktop\"]/div/form/div/div[2]/div/button/span/span[2]";
    public static final By COOKIE_BUTTON = By.xpath("//button[contains(@aria-label, 'Dismiss')]");
    private static final By searchbox  = By.xpath(SEARCH_BOX);

   public SearchPage(WebDriver driver) {
       this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   public void NavigateToHomePage() {
       driver.get("https://www.booking.com");

       try {
           WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(COOKIE_BUTTON));
           cookieButton.click();
       } catch (Exception e) {
           System.out.println("Cookie consent popup not found; continuing to page.");
       }
   }

   public void enterLocation(String location) {

       try{
           WebElement searchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_BOX)));
           searchbox.clear();
           searchbox.sendKeys(location);
       } catch (Exception e) {
           System.out.println("Error occurred while entering location; continuing to page.");
       }

    }

   /* public void enterLocation(String location) {
        WebElement searchbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_BOX)));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'}); arguments[0].focus();",
                searchbox
        );
        wait.until(ExpectedConditions.elementToBeClickable(searchbox)).click();
        searchbox.clear();
        searchbox.sendKeys(location);

    }*/


    public void selectCheckinDate() {
       WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SELECT_DATE_FIELD)));
       dateField.click();
   }

}
