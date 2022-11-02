package automated_test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {

	public WebDriver driver;

	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 System.out.println("Initializing webdriver");
	}
	
	public void searchItem() throws InterruptedException, IOException {
		driver.get("https://www.ebay.com/");
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File rs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs,new File("Ebay.png"));
		
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("motorola");
		Thread.sleep(3000);
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File rs2 = ts2.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs2,new File("EbayProduct.png"));
		
		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
		Thread.sleep(3000);
		TakesScreenshot ts3 = (TakesScreenshot) driver;	
		File rs3 = ts3.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs3,new File("EbayEnter.png"));
		
		driver.findElement(By.xpath("//*[contains(text(),'Motorola Moto G7 Plus - 64GB - Black (Unlocked) (Single SIM)')]")).click();
		Thread.sleep(3000);
		TakesScreenshot ts4 = (TakesScreenshot) driver;	
		File rs4 = ts4.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs4,new File("EbaySearch.png"));
		
//		String currWindow = driver.getWindowHandle();
//		Set<String> windows = driver.getWindowHandles();
//		Iterator itr = windows.iterator();
//		while(itr.hasNext()) {
//			String thisWindow = (String)itr.next();
//			if(!thisWindow.equalsIgnoreCase(currWindow)) {
//				driver.switchTo().window(thisWindow);
//				driver.findElement(By.xpath("//*[@id=\"isCartBtn_btn\"]")).click();
//				Thread.sleep(5000);
//				driver.findElement(By.xpath("//*[contains(text(),'Shopping cart (1 item)')]"));
//				Thread.sleep(5000);
//			}
//		}
	}

	public void addToCart() throws InterruptedException, IOException {
		driver.get("https://www.ebay.com/itm/394279137210?epid=14051397787&hash=item5bccde2fba:g:p9IAAOSw4HpjQclO&amdata=enc%3AAQAHAAAA4LILqWe%2BeGg%2FN%2BHcPoivHlj1MJrouxVUbYfD9O%2Fexh5hYku%2BDDJ3GDdf2f9aSm3c%2FOO4yb7oVuYps5oapMhRUladmtFA8tx57erMRXhJylTTESiyQdZRSyogcap6zkoJ%2FV8XxdGmjrUTtGa8VyftiO83MPFe%2BweJXkux5OmC%2FmpAmtHDl5i8pfc%2FZzUkD6ZU11sbiZ4ui3dLodN%2BMFB6Z%2Foiksq%2FLYiLvty6YsS1aiTCO5UFoMt2Wm4s8NG2vdND7eRXlLAn69JBnyXulsjqFIuuNHVEjuGxQum3dXaDguI2%7Ctkp%3ABFBM2tr7i_hg");
//		driver.switchTo().window(null);
		driver.findElement(By.xpath("//*[@id=\"isCartBtn_btn\"]")).click();
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;	
		File rs = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs,new File("EbayAddtoCart.png"));
		
		driver.findElement(By.xpath("//*[contains(text(),'Shopping cart (1 item)')]"));
		Thread.sleep(3000);
		TakesScreenshot ts2 = (TakesScreenshot) driver;	
		File rs2 = ts2.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(rs2,new File("EbayCheck.png"));

	}

	public void afterTest() {
		System.out.println("Closing WebDriver");
		driver.close();
	}
	
	@Test
	public void func() {
		AddToCart obj = new AddToCart();
		try {
			obj.beforeTest();

			obj.searchItem();

			obj.addToCart();

			obj.afterTest();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
