package automated_test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {
	public WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 System.out.println("Initializing webdriver");
	}
	
	@Test
	public void login() throws InterruptedException, IOException {

		driver.get("https://accounts.lambdatest.com/login");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ajithkumar0810@gmail.com");
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
		//sa.assertNotEquals(false, false);
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File rs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs,new File("Lemail.png"));
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ajith@one");
		Thread.sleep(3000);
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File rs2 = ts2.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs2,new File("Lpassword.png"));
		String parent = driver.getTitle();
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(15000);
		SoftAssert sa = new SoftAssert();
		sa.assertNotEquals(parent,driver.getTitle());
		sa.assertAll();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Closing WebDriver");
		driver.close();
	}
}
