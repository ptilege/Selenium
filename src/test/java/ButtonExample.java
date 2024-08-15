import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() throws InterruptedException {

        driver = new ChromeDriver( );
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);
        driver.get("https://www.leafground.com/button.xhtml");
       //Thread.sleep(3000);
    }

    @Test
    public void buttonTests(){
        //01.Click and confirm title.
        WebElement buttonClick = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        buttonClick.click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual Title same as expected");
        }else{
            System.out.println("Actual Title not same as expected");
        }
        //Assert.assertEquals(actualTitle,expectedTitle,"Title miss matched");


        //02.Find the position of the submit button.
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is : "+x+ " Y Position is :"+y);


        //03.Find the save button color.
        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("Button Color Is : "+color);

        //04.Find the height and width of this button.
        WebElement size =  driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height : "+height+ " Width : "+width);
    }
}
