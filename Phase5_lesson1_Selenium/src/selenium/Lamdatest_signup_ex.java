package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lamdatest_signup_ex {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");

	    WebDriver driver = new ChromeDriver(); // this intializes the chrome web browser
	    driver.get("https://accounts.lambdatest.com/register");
	    driver.manage().window().maximize();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Ajithkumar");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ajithkumar0810@gmail.com");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ajith@one");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8072791786");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//samp[@class='customcheckbox w-20 h-20 inline-block bg-white border border-gray-20 relative cursor-pointer mr-10']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@class='rounded border border-black block w-full xxld:text-size-20 xxl:text-size-18 xlx:text-size-16 xls:text-size-14 text-size-12 lg:h-35 xls:h-40 xlx:h-47 xxxl:h-54 xxld:h-60 h-40 tracking-widest font-bold uppercase g-recaptcha bg-black text-white  hover:bg-transparent hover:text-black']")).click();
	    Thread.sleep(5000);
	    
	    driver.get("https://accounts.lambdatest.com/login");
	    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ajithkumar0810@gmail.com");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ajith@one");
	    Thread.sleep(5000);
	    driver.findElement(By.id("login-button")).click();
	    Thread.sleep(15000);
	    driver.close();
	}
}
