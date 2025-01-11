package selenium.projects_LMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    
       	    WebDriver driver;
    	    
    	    // Setup function
    	    @BeforeClass
    	    public void setUp() {
    	        // Initialize Firefox driver
    	        driver = new FirefoxDriver();
    	        // Open the page
    	        driver.get("https://alchemy.hguy.co/lms");
    	    }
    	    
    	    // Test function
    	    @Test(priority = 1)
    	    public void Verify_the_website_title() {
       	        WebElement title = driver.findElement(By.xpath("//h3[normalize-space()='Actionable Training']"));
       	        String headerName = title.getText();
       	        System.out.println("The Header is : "+headerName);
    	        Assert.assertEquals(headerName, "Actionable Training");    	        
       	    }
    	     	       
    	    // Teardown function
    	    @AfterClass
    	    public void tearDown() {
    	        // Close the browser
    	        driver.close();
    	    }
    	}