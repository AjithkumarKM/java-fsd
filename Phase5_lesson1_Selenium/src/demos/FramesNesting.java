package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesNesting {
        public static void main(String[] args) throws InterruptedException{
        	
        		System.setProperty("webdriver.chrome.driver", "D:\\Mphasis Training\\Lesson 5\\Selenium\\LVS\\chromedriver_win32\\chromedriver.exe");
        		WebDriver driver = new ChromeDriver();	
    		                 
                //Navigate to the demo site
                driver.get("https://demoqa.com/nestedframes");
          
  //--------------------------------------------------------------------------------------------------------------//              
  //---------------Print the number of frames using Selenium WebDriver inside the parent frame ------------------//
  //-------------------------------------------------------------------------------------------------------------//              
                //Number of Frames on a Page
                int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
                System.out.println("Number of Frames on a Page:" + countIframesInPage);
                Thread.sleep(5000);
                
                //Locate the frame1 on the webPage
                WebElement frame1=driver.findElement(By.id("frame1"));
                
                //Switch to Frame1
                driver.switchTo().frame(frame1);
                
                Thread.sleep(3000);
                //Locate the Element inside the Frame1
                WebElement frame1Element= driver.findElement(By.tagName("body"));
                Thread.sleep(3000);
                
                //Get the text for frame1 element
                String frame1Text=frame1Element.getText();
                System.out.println("Frame1 is :"+frame1Text);
                
                //Number of Frames on a Frame1
                int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
                System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);
                Thread.sleep(5000);
                
                //switch to child frame
                driver.switchTo().frame(0);
                
                Thread.sleep(5000);
                int countIframesInFrame2 =driver.findElements(By.tagName("iframe")).size();
                System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame2);
                
                
                
  //-------------------------------------------------------------------------------------------------------//              
  //-----------------switch the context back to the parent iframe from the child iframe-------------------//
  //------------------------------------------------------------------------------------------------------//
    /*            //Number of Frames on a Page
                int countIframesInPage =driver. findElements(By. tagName("iframe")). size();
                System.out.println("Number of Frames on a Page:"+countIframesInPage);
                
                //Locate the frame1 on the webPage
                WebElement frame1=driver.findElement(By.id("frame1"));
                
                //Switch to Frame1
                driver.switchTo().frame(frame1);
                
                 //Number of Frames on a Frame1
                int countIframesInFrame1 =driver. findElements(By. tagName("iframe")). size();
                System.out.println("Number of Frames inside the Frame1:"+countIframesInFrame1);
                
                //Switch to child frame
                driver.switchTo().frame(0);
                int countIframesInFrame2 =driver. findElements(By. tagName("iframe")). size();
                System.out.println("Number of Frames inside the Frame2:"+countIframesInFrame2);
                
                //Locate the Element inside the Frame1
                WebElement frame1Element= driver.findElement(By.tagName("body"));
               
                //Get the text for frame1 element
                String frame1Text=frame1Element.getText();
                
                //Try to Print the text present inside parent frame
                System.out.println("Frame1 is :"+frame1Text);  
                
                
                //----------SWITCH BACK TO PARENT FRAME AGAIN AND PRINT TEXT------------//
                //Switch to Parent iFrame
                driver.switchTo().parentFrame();
                
                //Locate the Element inside the Frame1
                WebElement frame1Element= driver.findElement(By.tagName("body"));
                
                //Get the text for frame1 element
                String frame1Text=frame1Element.getText();
                
                //Try to Print the text present inside parent frame
                System.out.println("Frame1 is :"+frame1Text);
       */         
                driver.close();
        }
}
