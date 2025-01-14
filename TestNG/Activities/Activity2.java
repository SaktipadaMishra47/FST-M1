import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    
    // Setup function
    @BeforeClass
    public void setUp() {
        // Initialize Firefox driver
        driver = new FirefoxDriver();
        // Open the page
        driver.get("https://training-support.net/webelements/target-practice/");
    }
    
    // Test function
    @Test(priority = 1)
    public void testCas1() {
        // Assert page title
    	String title = driver.getTitle();
    	System.out.println("The tile is : "+title);
        Assert.assertEquals(title, "Selenium: Target Practice");
        
    }
    
    @Test(priority = 2)
    public void testCase2() {
        // This test case will Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }
    
    @Test(priority = 3 , enabled = false)
    public void testCase3() {
        // Assert page title
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }
    
    
    @Test(priority = 4)
    public void testCase4(){
    	throw new SkipException("Skipping test case.....");   	
    }
    
    // Teardown function
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

