import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {


    WebDriver driver;

    @BeforeMethod
    public void frameTestsPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){
        //01. Click Me (Inside frame)


        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After Click Button Text :"+afterClickButtonText);


        //02. Click Me (Inside Nested Frame)

        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);  //inside into third frame
        driver.switchTo().frame("frame2"); //inside into third frame > child frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText = button3.getText();
        System.out.println("After Click Inside Nested Frame Button Text :"+afterClickNestedFrameButtonText);




        //03. How many Frames In This page
        driver.switchTo().defaultContent();

        List<WebElement> getiframeTagCount =  driver.findElements(By.tagName("iframe"));
        int iframeCount = getiframeTagCount.size();
        System.out.println("Iframe Tag Count : "+iframeCount );

        for(WebElement iframeElement:getiframeTagCount){
            String frameSRCattributeValue = iframeElement.getAttribute("src");
            System.out.println("Frame src attribute value : "+frameSRCattributeValue);
        }



    }

}
