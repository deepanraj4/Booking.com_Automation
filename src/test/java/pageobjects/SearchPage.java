package pageobjects;


import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage  {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public static final String SEARCH_BOX = "//*[@id='searchbox-horizontal-destination-input']";
    public static final String SELECT_DATE_FIELD = "//*[@id=\"SearchBoxDesktop\"]/div/form/div/div[2]/div/button/span/span[2]";
    public static final String POPUP_CLOSE_BUTTON = "/html/body/div[2]/div/div/div/div[1]/div[1]/div/div/button";


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    }
   public void NavigateToHomePage() {

        driver.get("https://www.booking.com");
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(POPUP_CLOSE_BUTTON))).click();
    }

    public void enterLocation(String location){

       WebElement searchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_BOX)));
       searchbox.clear();
       searchbox.sendKeys(location);
    }

    public void selectCheckinDate(){
        driver.findElement(By.xpath(SELECT_DATE_FIELD)).click();
    }

}
