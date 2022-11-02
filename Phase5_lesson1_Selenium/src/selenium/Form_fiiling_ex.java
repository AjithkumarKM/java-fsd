package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form_fiiling_ex {

	public static void main(String args[]) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();			

        //-------------------------------RADIO-BUTTON----------------------------//
        driver.get("https://demo.automationtesting.in/Register.html");					
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ajith");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("kumar");
        Thread.sleep(2000);
        //
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("adjknskjvf");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("ajith@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("ajith@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Cricket']")).click();
        Thread.sleep(2000);
        
//		driver.findElement(By.id("msdd")).click();
//		driver.findElement(By.linkText("Czech")).click();
//		driver.findElement(By.linkText("Dutch")).click();
//		Thread.sleep(2000); 
//		
		Select skills = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
		skills.selectByValue("Adobe InDesign"); //1 : Method- selectByVisibleText()
		Thread.sleep(2000); 
		
		Select year = new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
		year.selectByValue("2000"); //1 : Method- selectByVisibleText()
		Thread.sleep(2000); 
		
		Select month = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
		month.selectByValue("October"); //1 : Method- selectByVisibleText()
		Thread.sleep(2000); 
		
		Select date = new Select(driver.findElement(By.xpath("//select[@id='daybox']")));
		date.selectByValue("6"); //1 : Method- selectByVisibleText()
		Thread.sleep(2000); 
		
        driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("thjia");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("thjia");
        Thread.sleep(2000);
        
        driver.findElement(By.id("submitbtn")).click();
        Thread.sleep(2000);
       
        driver.close();
	}
}
