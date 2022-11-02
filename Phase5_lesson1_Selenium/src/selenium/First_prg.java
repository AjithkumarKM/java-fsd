package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_prg {

	public static void main(String[] args) throws InterruptedException{
		// Step 1: load the chrome driver
	    System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");

	    WebDriver driver = new ChromeDriver(); // this intializes the chrome web browser
	    
	    // Step 2: open the url/website
//	    driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S553850044%3A1664878553811851&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AQDHYWoFphrsHdyc168OTrA8oAKPY5Bq5ucxbqNsG23w0in_eKbqNaJs0cCe5p4rE0D8FtjmRhl80g");
//	    
//	    // Step 3: make full screen of window
//	    driver.manage().window().maximize(); // this enables the browser to maximize its width and height
//	    Thread.sleep(6000); 
//	    driver.findElement(By.id("identifierId")).sendKeys("hello");
//	    
//	    Thread.sleep(4000);
//	    
//	    String title = driver.getTitle();
//	    if(title.equalsIgnoreCase("google"))
//	    	System.out.println("yes");
//		System.out.println("no");
	    
	    driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-603248432%3A1664882182951133&continue=https%3A%2F%2Faccounts.google.com%2F&followup=https%3A%2F%2Faccounts.google.com%2F&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AQDHYWr7aXuqSlCXuAD6YjDNo6rK72eFMdNGqENmh03dRdBy-rp3pJaqbxLi6U3DasOc6S4yY35d0g");
	    
	    // Step 3: make full screen of window
	    driver.manage().window().maximize(); // this enables the browser to maximize its width and height
	    Thread.sleep(6000); 
	    driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();;
		
		driver.close();
	    
	}
}
