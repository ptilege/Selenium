package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {
    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void webTableTest() throws InterruptedException {
        //01. How many rows in the Table.
        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Rows count is : "+rowCount);




        //02. How many columns in the table
        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Columns count is : "+columnCount);



        //03. Retrieve the specific row/column data
        String rowcolumnSpecificData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println(rowcolumnSpecificData);



        //04. Retrieve all the data from table
        for(int i = 1; i <= rowCount; i++){
            for (int j = 1; j < columnCount; j++) {
                String cellText = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();

                System.out.print(cellText + "  ");
            }
            System.out.println();
        }




        //05. print ID and Name only.
                //05.1 Find the product price, which Name related to Product 3
        for(int i = 1; i <= rowCount; i++){
            String tblId = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[1]")).getText();
            String tblProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println("table Id : "+tblId+"   Product Name Is : "+tblProductName);


            if(tblProductName.equals("Product 3")){
                String product3Price = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[3]")).getText();
                System.out.println(tblProductName + "Relevant product price is : " +product3Price);
                break;
            }
        }










        //06. Select all the checkBoxes.
        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for(int k=0; k < pageCount; k++){
            pages.get(k).click();
            Thread.sleep(1000);
            for (int i=1; i <= rowCount; i++ ){
                boolean atb = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).isSelected();
                if(!atb){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }
        }


        //07. Select one checkbox.
        int tblRow = 1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + tblRow + "]/td[4]/input")).click();
    }
}
