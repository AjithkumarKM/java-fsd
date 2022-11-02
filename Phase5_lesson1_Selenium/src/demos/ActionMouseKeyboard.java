package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionMouseKeyboard {

	public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();	
	
	String baseUrl = "http://www.facebook.com/"; 
	driver.get(baseUrl);
    
	Thread.sleep(2000); 
	WebElement txtUsername = driver.findElement(By.id("email"));
    Thread.sleep(2000);
    
	Actions builder = new Actions(driver);  // STEP-1
	
    Thread.sleep(5000);
	Action seriesOfActions = builder    //STEP-2
		.moveToElement(txtUsername)
		.click()
		.keyDown(txtUsername, Keys.SHIFT)
		.sendKeys(txtUsername, "hello")
		.keyUp(txtUsername, Keys.SHIFT)
		.doubleClick(txtUsername)
		.contextClick()
		.build();             //STEP-3
	
     Thread.sleep(5000);
	 seriesOfActions.perform();   //STEP-4
     driver.close();
}
}
