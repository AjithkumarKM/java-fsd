package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomateFlipkart2 {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("MicrosoftEdge");
		cap.setPlatform(Platform.WINDOWS);
		
		String hubURL = "http://192.168.56.1:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(hubURL),cap);
		System.out.println("Egde opening");
	}
	
	@Test(priority = 1)
	public void loadPage() throws InterruptedException {
		System.out.println("The thread ID for chrome is "+ Thread.currentThread().getId());
		driver.manage().window().maximize();
		long start = System.currentTimeMillis();
		driver.get("https://www.flipkart.com/");
		long finish = System.currentTimeMillis();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		long totalTime = finish - start; 
		System.out.println("Total Time for page load - "+totalTime);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[3]/a")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys("iphone 13");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	public void loadImage() {
//		boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[9]/div/div/div/a/div[1]/div[1]/div/div/img")).isDisplayed();
//		if(isDisplayed) {
//			System.out.println("\nImage Loaded");
//		}
//		else {
//			System.out.println("\nImage not Loaded");
//		}
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class); 
		wait.until(new Function<WebDriver, WebElement>() {

			@Test
			public WebElement apply(WebDriver driver) {
				WebElement img = driver.findElement(By.xpath(
						"//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img"));

				if (img.isDisplayed()) {
					System.out.println("\nImage Loaded");
					return img;
				} else {
					System.out.println("\nFluent Wait Fail!, Element Not Loaded Yet");
					return null;
				}	
			}
		});
	}
	
	@Test(priority = 4)
	public void scrollFeature() throws InterruptedException {
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
		if (test == true) {
			System.out.print("Scrollbar is present.");
		} else if (test == false){
			System.out.print("Scrollbar is not present.");
		}
		Thread.sleep(5000);
	}
	
	@Test(priority = 5) 
	public void downloadImg() throws IOException, InterruptedException {
		//Download image
		 WebElement logo = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[9]/div/div/div/a/div[1]/div[1]/div/div/img"));
		 String logoSRC = logo.getAttribute("src");

		 URL imageURL = new URL(logoSRC);
		 BufferedImage saveImage = ImageIO.read(imageURL);

		 ImageIO.write(saveImage, "png", new File("mobile-image.png"));
		 System.out.println("\nImage Downloaded");
		 Thread.sleep(5000);		
	}
	
	@Test(priority = 6)
	public void scrollFrequency() throws InterruptedException{
		 //scroll to particular image
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 long start2 = System.currentTimeMillis();
	     WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[9]"));
	     js.executeScript("arguments[0].scrollIntoView();", element);
	     long end2 = System.currentTimeMillis();
	     long totalTime2 = end2 - start2; 
	     System.out.println("Time taken to Scroll to particular image :: " + totalTime2 + "milliSecs") ;	     
	     System.out.println("Scrolled to particular image");
	     Thread.sleep(5000);
	}
	
	@Test(priority = 7)
	public void scrollToEnd() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		System.out.println("Scroller to end of page");
		Thread.sleep(5000);
	}
	
	@Test(priority = 8)
	public void screenRes() throws InterruptedException {
		Dimension dim = new Dimension(720, 1080);
		driver.manage().window().setSize(dim);
		Thread.sleep(5000);
		
		Dimension dim2 = new Dimension(1280, 800);
		driver.manage().window().setSize(dim2);
		Thread.sleep(5000);
		
		Dimension dim3 = new Dimension(2256, 1504);
		driver.manage().window().setSize(dim3);
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
		int contentWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
		System.out.println("\nWindow Height: " + contentHeight + " \nWindow  Width: " + contentWidth + "\n");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Closing edge browser");
		driver.quit();
	}
}
