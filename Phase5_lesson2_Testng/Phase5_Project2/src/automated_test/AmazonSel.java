package automated_test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSel {

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Led Tv");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"p_89/Samsung\"]/span/a/div/label/i")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"p_n_feature_thirteen_browse-bin/14354455031\"]/span/a/div/label/i")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Samsung 108 cm (43 inches) Crystal 4K Neo Series Ultra HD Smart LED TV UA43AUE65AKXXL (Black)')]")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
		//Thread.sleep(5000);
		//driver.get("https://www.amazon.in/Samsung-inches-Crystal-Ultra-UA55AUE65AKXXL/dp/B0B15GSPQW/ref=sr_1_4?crid=14NULUJXC1LN5&keywords=led+tv&qid=1665654135&qu=eyJxc2MiOiI2LjgyIiwicXNhIjoiNi44MCIsInFzcCI6IjUuMzEifQ%3D%3D&refinements=p_89%3ASamsung&rnid=3837712031&s=electronics&sprefix=led+t%2Caps%2C443&sr=1-4");
		Set<String> handles = driver.getWindowHandles();
		String thisName = driver.getWindowHandle();
		Iterator itr = handles.iterator();
		while(itr.hasNext()) {
			String newPage = (String)itr.next();
			if(!newPage.equalsIgnoreCase(thisName)) {
				//driver.navigate().to(newPage);
				driver.switchTo().window(newPage);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
				Thread.sleep(5000);
				//driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]")).click();
				driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
				Thread.sleep(5000);
				driver.close();
//				driver.findElement(By.xpath("//*[@id=\"sc-item-C364f3087-5dc8-4ecb-a96a-de3a0c89a9a4\"]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")).click();
//				Thread.sleep(5000);
			}
		}
		driver.switchTo().window(thisName);
		//*[@id="nav-cart-text-container"]/span[2]
		driver.findElement(By.xpath("//*[@id=\"nav-cart-text-container\"]/span[2]")).click();
		Thread.sleep(5000);
		//*[@id="sc-item-Cca92d76a-77ad-494f-954e-21776af4ffcf"]/div[4]/div/div[2]/div[1]/span[2]/span/input
		driver.findElement(By.xpath("//*[@id=\"sc-item-Cca92d76a-77ad-494f-954e-21776af4ffcf\"]/div[4]/div/div[2]/div[1]/span[2]/span/input")).click();
		Thread.sleep(5000);
	}
}
