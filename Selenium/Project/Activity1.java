package selenium.projects_LMS;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    
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
       	        String pageTitle = driver.getTitle();
       	        System.out.println("The page tile is : "+pageTitle);
    	        Assert.assertEquals(pageTitle, "Alchemy LMS – An LMS Application");    	        
       	    }
    	     	       
    	    // Teardown function
    	    @AfterClass
    	    public void tearDown() {
    	        // Close the browser
    	        driver.close();
    	    }
    	}