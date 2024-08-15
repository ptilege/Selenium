//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

    //Open google
    //Go to Google home page

    public static void main(String[] args){

      //System.setProperty("webdriver.chrome.driver","C:\\Users\\thara\\Downloads\\Driver\\chromedriver-win64\\chromedriver.exe");
      //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }
}
