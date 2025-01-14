import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
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
        driver.get("https://training-support.net/webelements/login-form/");
    }
    
    // Test function
    @Test(priority = 1)
    public void login() {
    	 WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
    	 WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
    	 WebElement submit   = driver.findElement(By.xpath("//button[@class='svelte-1pdjkmx']"));
    	     	 
    	 userName.sendKeys("admin");
    	 passWord.sendKeys("password");
       	 submit.click();
       	 
    	 WebElement message = driver.findElement(By.xpath("//h1[@class='text-center font-display text-6xl font-bold text-emerald-500']"));
       	 Assert.assertEquals("Login Success!", message.getText());
    	 
    }
    // Teardown function
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

