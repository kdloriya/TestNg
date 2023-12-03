package KishanPractice.TestNG;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgTest{

	WebDriver driver = null;
	
	@BeforeTest
    public void setup()
    {
		//driver setup
		ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");
	   	driver = new ChromeDriver(option);
	   	driver.manage().window().maximize();
	   	
	   	//Navigating and Waiting
	   	driver.get("https://www.google.com/");
    	driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
    	//Applying Explicit wait
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='dropdown-class-example']")));
	}
	
	
    @Test (priority=0)
		  public void radioButtons () throws InterruptedException {
		    	
		   	WebElement radioBtn = driver.findElement((By.xpath("//legend[contains(text(), 'Radio')]/parent::fieldset")));
		   	//System.out.println(radioBtn.getText());
		   	List <WebElement> allRadioBtns = radioBtn.findElements(By.tagName("label"));
		   	int noOFRadioBtn = allRadioBtns.size();
		   	//System.out.println(noOFRadioBtn);
		    	
		   	if (noOFRadioBtn == 3) {
		   		WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		   		radio1.click();
		   		WebElement radio2 = driver.findElement(By.xpath("//input[@value='radio2']"));
		   		radio2.click();
		   		WebElement radio3 = driver.findElement(By.xpath("//input[@value='radio3']"));
		    	radio3.click();
		    		if(radio3.isSelected()) {
		    				//System.out.println("Radio buttons are selected");
	    			}
		   		} else {
		   			
		  			System.out.println("No of Radio buttons are: " + noOFRadioBtn);
		    	}
	   	
		  }
    
    
    @Test (priority=1)
	      public void countrySuggestion () throws InterruptedException {
		  
		   driver.findElement(By.xpath("//legend[contains(text(), 'Suggession')]/parent::fieldset/input")).sendKeys("In"); 
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//li/div[text()='India']")).click();
		  	    
		   }
	 
    
    @Test (priority=3)
	      public void dropdown () {
    	
	    	WebElement dropdownBtn = driver.findElement(By.xpath("//select[@name='dropdown-class-example']"));
	    	List <WebElement> dropwonOptions = dropdownBtn.findElements(By.tagName("option"));
	    	int dropdownCount = dropwonOptions.size();
	    	    	
	    	if (dropdownCount == 4) {
	 
	    		dropdownBtn.click();
	    		driver.findElement(By.xpath("//option[text()='Option2']")).click();
	    		
	    	} else {
	    		System.out.println("No. of options in dropdown are: " + dropdownCount);
	    	}
	    }
    
    @Test (priority=4)
		  public void checkBox() {

    		WebElement checkBox = driver.findElement(By.xpath("//legend[contains(text(), 'Checkbox')]/parent::fieldset"));
    		List <WebElement> checkOptions = checkBox.findElements(By.tagName("label"));
    		int totalCheck = checkOptions.size();
    		
    		if (totalCheck == 3) {
    			driver.findElement(By.xpath("//input[@value='option2']")).click();
    			
    		} else {
    			System.out.println("No of checkbox is: " + totalCheck);
    		}
    }
    
    @AfterTest
    public void end () {
    	
    	//driver.quit();
    	System.out.println("Flow complete");
    }
}