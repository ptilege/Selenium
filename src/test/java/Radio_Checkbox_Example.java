import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_Checkbox_Example  {

    WebDriver driver;

    @BeforeMethod
    public void radio_checkbox_BeforeTests(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTests(){
        //<<<<<<<radio>>>>>>>
        //01. Find the default select radio button.
        driver.get("https://www.leafground.com/radio.xhtml");

        boolean chromeradioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxradioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chromeradioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is :"+chromeText);
        }else if(firefoxradioOption){
            String fireFoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is :"+fireFoxText);
        }else if(safariradioOption){
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is :"+safariText);
        }else if(edgeradioOption){
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("default select radio button is :"+edgeText);
        }


//
//        List<WebElement> radioElements = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
//        int radioCount = radioElements.size();
//        System.out.println("Radio size : "+radioCount);
//
//        int index = -1;
//
//        for(WebElement radioElement : radioElements){
//            index++;
//            if(radioElement.isSelected()){
//                WebElement defaultSelectedRadioButton = driver.findElement(By.xpath("//label[@for='j_idt87:console2:" + index +"']"));
//                String defaultSelectedRadioButtonText = defaultSelectedRadioButton.getText();
//                System.out.println("Default Selected Radio Button Text : "+defaultSelectedRadioButtonText);
//                break;
//            }
//        }




        //02. Select the age group (only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();

        if(!isChecked){
            //myAgeGroup.click();

            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }
    }

    @Test
    public void CheckBoxTest(){
        //<<<<<<<CheckBox>>>>>>>
        //01. Select wanted checkboxes and Verifying those checkboxes selected status

        driver.get("https://www.leafground.com/checkbox.xhtml");


        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for(WebElement element : checkBoxList){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for(int i=1; i<=checkBoxList.size(); i++){
            boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+ i+"]")).isSelected();
            System.out.println("CheckBox "+ i + "selected status is : " + checkBoxStatus);
        }

    }
}
