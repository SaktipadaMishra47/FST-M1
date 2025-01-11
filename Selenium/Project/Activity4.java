package selenium.projects_LMS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Activity4 {
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
	        WebElement header = driver.findElement(By.xpath("//h3[normalize-space()='Email Marketing Strategies']"));
	        String headerName = header.getText();
	        System.out.println("The Title is : "+headerName);
        Assert.assertEquals(headerName, "Email Marketing Strategies");    	        
	    }
     	       
    // Teardown function
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.close();
    }
}

