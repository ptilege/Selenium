package Screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshotsCommonMethods {

    public static void takeWebPageScreenShot(WebDriver driver, String filename) throws IOException {
        //Create a date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
        //Get the current date and time
        Date date = new Date();
        //Format the date and time
        String timestamp = formatter.format(date);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "\\screenshot\\" + filename + "_" + timestamp + ".png");
        FileHandler.copy(sourceFile,destinationFile);
    }


    public static void takeEntireScreenshot(String filename) throws AWTException, IOException {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source = robot.createScreenCapture(rectangle);

        File destinationFile = new File(System.getProperty("user.dir") + "\\screenshot\\"+filename+ "_" + timestamp + ".png");
        ImageIO.write(source,"png",destinationFile);
    }
}
