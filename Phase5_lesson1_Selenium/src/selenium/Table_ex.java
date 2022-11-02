package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_ex {
public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {									
		
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		
        // Alert Message handling                   		
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");			
      //*[@id="customers"] 		
      //*[@id="customers"]/tbody/tr[1]
        Thread.sleep(2000);
        @SuppressWarnings("rawtypes")
        List  rows = driver.findElements(By.xpath(".//*[@id='customers']/tbody/tr")); 
        System.out.println("No of cols are : " +rows.size()); 
        Thread.sleep(2000);	
        @SuppressWarnings("rawtypes")
		List  cols = driver.findElements(By.xpath(".//*[@id='customers']/tbody/tr[1]/th")); 
        System.out.println("No of cols are : " +cols.size()); 
        
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//*[@id="customers"]/tbody/tr[1]
		  
		 //To find third row of table
        String rowtext = driver.findElement(By.xpath(".//*[@id='customers']/tbody/tr[2]")).getText();
		 System.out.println("Third row of table : "+rowtext);
		 Thread.sleep(2000);
		 
		WebElement baseTable = driver.findElement(By.id("customers"));
		 //WebElement baseTable = driver.findElement(By.tagName("table"));
		System.out.println(baseTable);
		WebElement rowText = baseTable.findElement(By.xpath("//*[@id='customers']/tbody/tr[2]"));
		//WebElement rowText = baseTable.findElement(By.xpath(".//tbody/tr[2]"));
		System.out.println(rowtext);
	}
}
