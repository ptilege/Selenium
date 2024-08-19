import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptExecutionExample {

    ChromeDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void openJSExecution(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }


    @Test
    public void jsExecutorTests() throws InterruptedException {


        jsExecutor = driver;

        //01. Get a Alert Box in to Web page using javascript
        //jsExecutor.executeScript("alert('My name is pasindu...');");






        //02. Set a input value in a text box using javascriptExecutor.
              //02.1 Way 1 -> Set the value using the value property (common approach)


        WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        //jsExecutor.executeScript("arguments[0].value='Pasindu Tharaka';",inputNameTextBox);


              //02.2 Way 2 -> Set the value using setAttribute (alternative approach)
        jsExecutor.executeScript("arguments[0].setAttribute('value','Pasindu Tharaka');",inputNameTextBox);

        Thread.sleep(4000);



        //03. Highlight element.
        jsExecutor.executeScript("arguments[0].style.border='3px solid red';", inputNameTextBox);
        jsExecutor.executeScript("arguments[0].style.background='yellow';", inputNameTextBox);





        //04. Click element using javascriptExecutor
        WebElement maleCheckBox = driver.findElement(By.xpath("//input[@id='male']"));
        jsExecutor.executeScript("arguments[0].click();",maleCheckBox);

        Thread.sleep(4000);



        //05. Scrolling the page.
        scrollPage();





        //06. Get all attribute from a wanted element.
        getAllAttributes(inputNameTextBox);



    }

    public void scrollPage() throws InterruptedException {
        //5.1  scroll to some position.
        jsExecutor.executeScript("window.scrollTo(0,1000);");
        jsExecutor.executeScript("window.scrollTo(0,-1000);");
        Thread.sleep(5000);

        //5.2 Scroll to bottom of the page by pixel Number.
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(5000);


        //5.3 Scroll to the top of the page.
        jsExecutor.executeScript("window.scrollTo(0,0);");
        Thread.sleep(5000);

        //5.4 Scroll the page till element is visible.
        WebElement scrollintoElement = driver.findElement(By.xpath("//div[@class='fauxborder-left main-fauxborder-left']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",scrollintoElement);
        Thread.sleep(5000);


    }

    public String getAllAttributes(WebElement webElement){
        Object elementAttributes = jsExecutor.executeScript(
                "var items = {}; " +
                        "for (var index = 0; index < arguments[0].attributes.length; ++index) { " +
                        "var attr = arguments[0].attributes[index]; " +
                        "items[attr.name] = attr.value; " +
                        "} " +
                        "return items;",
                webElement);
        System.out.println("All Attribute value are : "+elementAttributes.toString());
        return elementAttributes.toString();
    }
}
