package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenShotExample {
    WebDriver driver;

    @BeforeMethod
    public void openWebPage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void takeScreenshotTests() throws IOException, AWTException {




        //02. Capture screenshots of selection of a web page.

        WebElement section1PageElement = driver.findElement(By.xpath("//*[@id='j_idt88\']/div/div[1]"));
        File source = section1PageElement.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\screenshot\\"+ "alert_section_of_WebPage.png");
        FileUtils.copyFile(source,target);




        //03. Capture screenshot of an element on a web page.

        WebElement elementOfThePage = driver.findElement(By.xpath("//*[@id=\'j_idt88\']/div/div[1]/div[1]"));
        File source1 = elementOfThePage.getScreenshotAs(OutputType.FILE);
        File target1 = new File(System.getProperty("user.dir") + "\\screenshot\\"+ "alert_element_of_WebPage.png");
        FileUtils.copyFile(source1,target1);

        //01. Capture screenshot of full web page.

//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File(System.getProperty("user.dir") + "\\screenshot\\"+ "alertFullWebPage.png");
//        FileHandler.copy(sourceFile,destinationFile);


        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();




        //04. Capture screenshot of an full entire screen.

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source2 = robot.createScreenCapture(rectangle);
        File destinationFile2 = new File(System.getProperty("user.dir") + "\\screenshot\\"+ "alertPageEntireScreen.png");
        ImageIO.write(source2,"png",destinationFile2);



    }
}
