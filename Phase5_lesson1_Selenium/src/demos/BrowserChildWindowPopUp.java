package demos;

import java.util.Iterator;		
import java.util.Set;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;			

public class BrowserChildWindowPopUp {				

    public static void main(String[] args) throws InterruptedException {	
    	
    	//setting the driver executable
    	System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		
        //Launching the site.				
        driver.get("http://demo.guru99.com/popup.php");			
        driver.manage().window().maximize();		
                		
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();	
        Thread.sleep(3000);
        		
        String MainWindow=driver.getWindowHandle();		
        System.out.println("current window handler:  "+ MainWindow);
        
        Thread.sleep(3000);
        //To handle all new opened window.				
        Set<String> s1=driver.getWindowHandles();  //---> it stores all the child windows opened
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();	
            System.out.println("current child window handler:  "+ ChildWindow);
            Thread.sleep(2000); 
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		           
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);
                    Thread.sleep(4000);
                    driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");                			
                    
                    Thread.sleep(4000);
                    driver.findElement(By.name("btnLogin")).click();			
                    Thread.sleep(4000);             
			// Closing the Child Window.
            driver.close();		
            }		
        }		
        // Switching to Parent window i.e Main Window.
            Thread.sleep(4000);            
            driver.switchTo().window(MainWindow);	
            driver.close();
    }
}	
