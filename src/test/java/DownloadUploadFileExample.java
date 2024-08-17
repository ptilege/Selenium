import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {

    WebDriver driver;

    @BeforeMethod
    public void openFileTestsPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\thara\\Downloads");
        File[] totalFiles = file.listFiles();
        for(File findFile :totalFiles){
            if(findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is Downloaded");
                break;
            }
        }

    }



    @Test
    public void fileUploadTest() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");

        //01. 1st Way = Using Send Keys (Application only element type is file)

        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

        //windows control begin here

        String data = "C:\\Users\\thara\\Downloads\\sample.jpg";
        StringSelection selection = new StringSelection(data);
        //copying the path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(4000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //02. 2nd Way = Using Robot class

        WebElement uploadusingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadusingSendKeys.sendKeys(data);

    }
}
