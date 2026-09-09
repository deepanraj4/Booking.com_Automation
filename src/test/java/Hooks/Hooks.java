package Hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
   @After
    public void tearDown(){
        if (driver != null) {
                try {

                    Thread.sleep(5000);
                    // wait up to 5 seconds for the page to reach readyState 'complete'
                    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                   // wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                          // .executeScript("return document.readyState").equals("complete"));
                } catch (Exception e) {
                   System.out.println("Exception occurred while waiting for page to load: " + e.getMessage());
                   // ignore timeouts or other exceptions and proceed to quit
                }
               driver.quit();
            }
        }

}
