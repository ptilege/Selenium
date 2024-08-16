import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowTestsPage {

    WebDriver driver;

    @BeforeMethod
    public void windowTestsPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void windowTests() throws InterruptedException {
        //01.click and confirm new window opens.

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window : "+oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("handles size :" +handles.size());

          // First method - using foreach loop.

//        for(String newWindow : handles){
//            System.out.println(newWindow);
//            driver.switchTo().window(newWindow);
//            System.out.println("Page Title is : "+driver.getTitle());
//        }
//
//        driver.close();
//
//        driver.switchTo().window(oldWindow);
//
//        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
//        boolean openbuttonVisibility = openButton1.isDisplayed();
//        System.out.println("Open button Visibility "+openbuttonVisibility);



          // Second method - using List.

        List<String> list = new ArrayList<String>(handles); //Converting Set to The List.
        if(list.size() > 1){
            driver.switchTo().window(list.get(1));
            System.out.println("child tab title is : "+driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);
        }


        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button Visibility "+openbuttonVisibility);


        //02. Find the number of opened tabs.

        WebElement multiWindowButton = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int howmanywindows = multiWindows.size();
        System.out.println("Number Of Windows Open : "+howmanywindows);


        //03. Close all windows except Primary.

        WebElement dontclosemeButton = driver.findElement(By.id("j_idt88:j_idt91"));
        dontclosemeButton.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandles = driver.getWindowHandles();
        for(String allwindows : newWindowsHandles){
            if(!allwindows.equals(oldWindow)){
                driver.switchTo().window(allwindows);
                driver.close();
            }
        }

//        driver.switchTo().window(oldWindow);
//        driver.close(); --> close single browser window driver which on focus
          //driver.quit(); //-->close all browser windows

    }
}
