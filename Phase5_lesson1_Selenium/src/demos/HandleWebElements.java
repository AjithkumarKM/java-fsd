package demos;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;	

public class HandleWebElements {
	
	public static void main(String[] args) throws InterruptedException {									
		
    	// declaration and instantiation of objects/variables		
		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();			

        //-------------------------------RADIO-BUTTON----------------------------//
        driver.get("http://demo.guru99.com/test/radio.html");					
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
        		
        //Radio Button1 is selected		
        radio1.click();			
        System.out.println("Radio Button Option 1 Selected");					
        		
        //Radio Button1 is de-selected and Radio Button2 is selected		
        radio2.click();			
        System.out.println("Radio Button Option 2 Selected");					
        
        Thread.sleep(4000);
       
        //------------------------------ CHECKBOX----------------------------------//
        // Selecting CheckBox		
        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							

        // This will Toggle the Check box 		
        option1.click();			

        // Check whether the Check box is toggled on 		
        if (option1.isSelected()) {					
            System.out.println("Checkbox is Toggled On");					

        } else {			
            System.out.println("Checkbox is Toggled Off");					
        }		
        
        Thread.sleep(5000); 
        //Selecting Checkbox and using isSelected Method		
        
        driver.get("http://demo.guru99.com/test/facebook.html");					
        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));		
        Thread.sleep(10000); 
        for (int i=0; i<2; i++) {											
            chkFBPersist.click (); 			
            System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());							
        }		
        Thread.sleep(10000);
        
        //-------------------------------DROP-DOWN---------------------------------//
        driver.get("http://demo.guru99.com/test/newtours/register.php");	
        Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("ANTARCTICA"); //1 : Method- selectByVisibleText()
		Thread.sleep(7000); 
		drpCountry.selectByValue("ALGERIA");   //2 : Method- selectByValue()
		Thread.sleep(9000); 

		
		//------------------------MULTI SELECT DROP-DOWN BOX------------------------//
		//Selecting Items in a Multiple SELECT elements
		driver.get("http://jsbin.com/osebed/2");
		Thread.sleep(3000);
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);           //3 : selectByIndex()
		Thread.sleep(5000);
		driver.close();		    		
    }	

}
