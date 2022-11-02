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

public class Registrstion {

	public WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 System.out.println("Initializing webdriver");
	}
	
	@Test
	public void register() throws InterruptedException, IOException {
		SoftAssert sa = new SoftAssert();
		
		driver.get("https://accounts.lambdatest.com/register");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("abcd");
		Thread.sleep(2000);
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File rs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs,new File("Rname.png"));
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abcd@gmail.com");
		Thread.sleep(3000);
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File rs2 = ts2.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs2,new File("Remail.png"));
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd@one");
		Thread.sleep(3000);
		TakesScreenshot ts3 = (TakesScreenshot) driver;	
		File rs3 = ts3.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs3,new File("Rpassword.png"));
		
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8072691786");
		Thread.sleep(3000);
		TakesScreenshot ts4 = (TakesScreenshot) driver;	
		File rs4 = ts4.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs4,new File("Rphone.png"));
		
		driver.findElement(By.xpath("//samp[@class='customcheckbox w-20 h-20 inline-block bg-white border border-gray-20 relative cursor-pointer mr-10']")).click();
		Thread.sleep(3000);
		TakesScreenshot ts5 = (TakesScreenshot) driver;	
		File rs5 = ts5.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs5,new File("Rcheckbox.png"));
		
		driver.findElement(By.xpath("//button[@class='rounded border border-black block w-full xxld:text-size-20 xxl:text-size-18 xlx:text-size-16 xls:text-size-14 text-size-12 lg:h-35 xls:h-40 xlx:h-47 xxxl:h-54 xxld:h-60 h-40 tracking-widest font-bold uppercase g-recaptcha bg-black text-white  hover:bg-transparent hover:text-black']")).click();
		Thread.sleep(3000);
		TakesScreenshot ts6 = (TakesScreenshot) driver;	
		File rs6 = ts6.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs6,new File("Rsubmit.png"));
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Closing WebDriver");
		driver.close();
	}
}
