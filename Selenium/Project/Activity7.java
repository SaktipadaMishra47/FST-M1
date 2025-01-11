package selenium.projects_LMS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
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
    public void count_The_Number_Of_Courses() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Find all the navigation items
        List<WebElement> navigationBar = driver.findElements(By.xpath("//div[@class='main-navigation']//a"));

        boolean myAccountFound = false;

        System.out.println("**************************************************************");
        // Iterate over navigation items
        for (WebElement item : navigationBar) {
            System.out.println(item.getText());

            // Check if this is the "My Account" link
            if (item.getText().equalsIgnoreCase("All Courses")) {
                // Wait until the "My Account" link is clickable
                wait.until(ExpectedConditions.elementToBeClickable(item));

                // Click the link
                item.click();
                System.out.println("Moving to the next Page");

                myAccountFound = true;
                break;
            }
        }

        // Assert that we found the "My Account" page
        Assert.assertTrue(myAccountFound, "All Courses link was not found in the navigation bar");

        // Verify the title of the page after navigation
        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']"));
        System.out.println("The Title is: " + pageTitle.getText());
        Assert.assertEquals(pageTitle.getText(), "All Courses");
        System.out.println("**************************************************************");
        
        List<WebElement> allCourses = driver.findElements(By.xpath("//h3[@class='entry-title']"));
         wait.until(ExpectedConditions.visibilityOfAllElements(allCourses));
         System.out.println("The total number of courses are: " + allCourses.size());   
        	for (WebElement course : allCourses) {        		
        		System.out.println("Course details: " + course.getText());        		    		     	
        	}
        }
        
    // Teardown function
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
