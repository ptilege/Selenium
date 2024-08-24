package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitDemo {
    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void explicitWaitTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
        WebElement NewBtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='j_idt87:j_idt90']/span")));
        String newButtonText = NewBtnElement.getText();
        System.out.println("New Button Text Is : "+newButtonText);


    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
