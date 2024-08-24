package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void fluentWaitTest(){

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement fluentWaitElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span"));
            }
        });




        String newButtonText = fluentWaitElement.getText();
        System.out.println("New Button Text Is : "+newButtonText);


    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
