package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_ex {
public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {									
		
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		
        // Alert Message handling                   		
        driver.get("https://demo.automationtesting.in/Alerts.html");			
                            		
        Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]")).click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		//alert1.accept();
		alert.dismiss();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box ')]")).click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(2000);
		//alert1.accept();
		//alert.dismiss();
		//alert.sendKeys("hello");
		//Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		
	}
}
