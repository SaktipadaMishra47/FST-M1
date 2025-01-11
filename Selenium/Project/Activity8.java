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

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Activity8{
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
    public void contact_the_admin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Find all the navigation items
        List<WebElement> navigationBar = driver.findElements(By.xpath("//div[@class='main-navigation']//a"));
        boolean contact = false;
        // Iterate over navigation items
        for (WebElement item : navigationBar) {
            System.out.println(item.getText());

            // Check if this is the "“Contact”" link
            if (item.getText().equalsIgnoreCase("Contact")) {
                // Wait until the "“Contact”" link is clickable
                wait.until(ExpectedConditions.elementToBeClickable(item));
                // Click the link
                item.click();
                System.out.println("Moving to the next Page");
                contact = true;
                break;
            }
        }

        // Assert that we found the "“Contact”" page
        Assert.assertTrue(contact, "Contact link was not found in the navigation bar");

        // Verify the title of the page after navigation
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='uagb-ifb-title-wrap']"));
        System.out.println("The Title is: " + pageTitle.getText());
        Assert.assertEquals(pageTitle.getText(), "Need Help?");

        // Wait for the login button to be clickable
        WebElement needHelp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='uagb-ifb-title']")));
        Assert.assertTrue(needHelp.isDisplayed(),"Need Help message is not displyed then contact page has not been opened");
        
        System.out.println("**************************On Need help page************************************");
        
        // Wait for the login fields to be visible and interactable
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpforms-8-field_0")));
        WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpforms-8-field_1")));
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.id("wpforms-8-field_2")));
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("wpforms-submit-8")));
        
        // Input credentials and submit
        userName.sendKeys("Sakti");
        mail.sendKeys("sakti@gmail.com");
        message.sendKeys("Hello Sakti");
        sendButton.click();
        System.out.println("***************************Submitted the Form***********************************");
        
        // Wait for the logout button to appear after successful login
        WebElement confirmMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpforms-confirmation-8")));
        System.out.println("The confirmMessage Displaying as : " + confirmMessage.getText());

        // Assert that the logout button is displayed, confirming the login
        Assert.assertTrue(confirmMessage.isDisplayed(), "confirmMessage is not displayed, Contact might have failed.");
    }

    // Teardown function
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
