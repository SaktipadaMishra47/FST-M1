import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    
    // Setup function
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        // Initialize Firefox driver
        driver = new FirefoxDriver();
        driver.get(" https://training-support.net/webelements/target-practice");
    }
    
    // Test function
    @Test(groups = {"HeaderTests" ,"ButtonTests"})
    public void checkThePagetitle() {
    	String title = driver.getTitle();
    	System.out.println("The tile is : "+title);
        Assert.assertEquals(title, "Selenium: Target Practice");        
    }
    
    @Test(dependsOnMethods = "checkThePagetitle" , groups = "HeaderTests")
    public void findTheThirdHeader() {
        // This test case will Fail
        WebElement thirdHeader = driver.findElement(By.xpath("//h3[@class='text-3xl font-bold text-orange-600']"));
        Assert.assertTrue(thirdHeader.isDisplayed());
        Assert.assertEquals(thirdHeader.getText(), "Heading #3");
    }
    
    @Test(dependsOnMethods = "checkThePagetitle" ,groups = "HeaderTests")
    public void findTheFifthHeaderColor() {
    	            Color header5Color = Color
                    .fromString(driver.findElement(By.cssSelector("h3#third-header")).getCssValue("color"));
            Assert.assertEquals(header5Color.asHex(), "#9333ea");
    }
    
    @Test(dependsOnMethods = "checkThePagetitle",groups = "ButtonTests")
    public void ButtonTest1() {
        WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
        ;
        Assert.assertEquals(button1.getText(), "Emerald");
    }
    
    @Test(dependsOnMethods = "checkThePagetitle" ,groups = "ButtonTests")
    
    public void ButtonTest2() {
        Color button2Color = Color
                .fromString(driver.findElement(By.xpath("//button[contains(@class, 'teal')]")).getCssValue("color"));
        Assert.assertEquals(button2Color.asHex(), "#134e4a");
    }
    
    // Teardown function
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

