package pageobjects;


import BasePage.BaseClass;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BaseClass {

    public final WebDriver driver;
    public final WebDriverWait wait;

    public static final String SEARCH_BOX = "//*[@id='searchbox-horizontal-destination-input']";
    public static final String SELECT_DATE_FIELD = "//*[@id=\"SearchBoxDesktop\"]/div/form/div/div[2]/div/button/span/span[2]";
    public static final By COOKIE_BUTTON = By.xpath("//button[contains(@aria-label, 'Dismiss')]");
    public static final By SELECT_GUEST = By.xpath("//button[@data-testid='occupancy-config']");
    public static final By MINUS_GUEST_COUNT = By.xpath("//input[@id='group_adults']/following-sibling::button[1]");
    public static final By PLUS_GUEST_COUNT = By.xpath("//input[@id='group_adults']/following-sibling::button[2]");
    public static final  By CURRENT_GUEST_COUNT = By.xpath("//input[@id='group_adults']");
    public static final By CURRENT_ROOM_COUNT = By.xpath("//input[@id='no_rooms']");
    public static final By MINUS_ROOM_COUNT = By.xpath("//input[@id='no_rooms']/following-sibling::button[1]");
    public static final By PLUS_ROOM_COUNT = By.xpath("//input[@id='no_rooms']/following-sibling::button[2]");
    public static final By SEARCH_BUTTON =By.xpath("//Button[@type='submit']");

    //@FindBy(id="group_adults")
   // private WebElement CURRENT_GUEST_COUNT;


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

        try {
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


    public void selectCheckinDate(String checkindate) {
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SELECT_DATE_FIELD)));
        dateField.click();
        By SELECT_CHECKIN_DATE = By.xpath("//span[@data-date='" + checkindate + "']");
        WebElement selectDate = wait.until(ExpectedConditions.elementToBeClickable((SELECT_CHECKIN_DATE)));
        selectDate.click();
    }

    public void selectCheckoutDate(String checkoutdate) {

      By CHECK_OUT_DATE = By.xpath("//span[@data-date='" + checkoutdate + "']");
      WebElement selectDate = wait.until(ExpectedConditions.elementToBeClickable(CHECK_OUT_DATE));
      selectDate.click();
    }

    public void select_numberof_guests(int numberofguest){

        WebElement selectGuestCount =  wait.until(ExpectedConditions.elementToBeClickable((SELECT_GUEST)));
        selectGuestCount.click();

        WebElement currentguestcount = wait.until(ExpectedConditions.presenceOfElementLocated(CURRENT_GUEST_COUNT));
        int currentGuests = Integer.parseInt(
                currentguestcount.getAttribute("aria-valuenow"));

        System.out.println("Current guests: " + currentGuests);
        System.out.println("Number of guests: " + numberofguest);

        while (currentGuests < numberofguest){

            WebElement AddGuestValue = wait.until(ExpectedConditions.presenceOfElementLocated(PLUS_GUEST_COUNT));
            AddGuestValue.click();
            currentGuests = Integer.parseInt(currentguestcount.getAttribute("aria-valuenow"));

        }
        while (currentGuests > numberofguest){

            WebElement minusGuestValue = wait.until(ExpectedConditions.presenceOfElementLocated(MINUS_GUEST_COUNT));
            minusGuestValue.click();
            currentGuests = Integer.parseInt(currentguestcount.getAttribute("aria-valuenow"));

        }
        System.out.println("Final guests: " + currentGuests);

        }


        public void select_numberof_rooms(int numberofrooms){

        WebElement currentroomcount = wait.until(ExpectedConditions.presenceOfElementLocated(CURRENT_ROOM_COUNT));
        int currentroomvalue = Integer.parseInt(currentroomcount.getAttribute("aria-valuenow"));

        System.out.println("Current rooms: " + currentroomvalue);
        System.out.println("Number of rooms: " + numberofrooms);

        while (currentroomvalue < numberofrooms){

            WebElement addroomvalue = wait.until(ExpectedConditions.presenceOfElementLocated(PLUS_ROOM_COUNT));
            addroomvalue.click();

            currentroomvalue = Integer.parseInt (currentroomcount.getAttribute("aria-valuenow"));

        }

        while (currentroomvalue > numberofrooms){
            WebElement minusroomvalue = wait.until(ExpectedConditions.presenceOfElementLocated(MINUS_ROOM_COUNT));
            minusroomvalue.click();

            currentroomvalue= Integer.parseInt(currentroomcount.getAttribute("aria-valuenow"));
        }
        System.out.println("Final rooms: " + currentroomvalue);
        }

        public void clickSearchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(SEARCH_BUTTON));
        searchButton.click();

        }
    }
