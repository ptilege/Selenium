import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setup() {
        // Initialize ExtentReports with ExtentSparkReporter
        ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Setting system information for the report
        extent.setSystemInfo("Host Name", "Your Host");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Pasindu Tharaka");

        // Initialize WebDriver
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTests() {
        test = extent.createTest("Button Tests", "Testing various button functionalities");

        try {
            //01. Click and confirm title.
            WebElement buttonClick = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
            buttonClick.click();
            String expectedTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Title mismatched");
            test.pass("Title is confirmed as 'Dashboard'");

            //02. Find the position of the submit button.
            driver.navigate().back();
            WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
            Point xyPoint = getPosition.getLocation();
            int x = xyPoint.getX();
            int y = xyPoint.getY();
            test.pass("X position: " + x + ", Y position: " + y);

            //03. Find the save button color.
            WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
            String color = buttonColor.getCssValue("background-color");
            test.pass("Button color is: " + color);

            //04. Find the height and width of this button.
            WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
            int height = size.getSize().getHeight();
            int width = size.getSize().getWidth();
            test.pass("Height: " + height + ", Width: " + width);

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        extent.flush();  // Generate the report
    }
}
