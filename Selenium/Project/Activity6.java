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

public class Activity6 {
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
    public void logging_into_the_site() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Find all the navigation items
        List<WebElement> navigationBar = driver.findElements(By.xpath("//div[@class='main-navigation']//a"));

        boolean myAccountFound = false;

        // Iterate over navigation items
        for (WebElement item : navigationBar) {
            System.out.println(item.getText());

            // Check if this is the "My Account" link
            if (item.getText().equalsIgnoreCase("My Account")) {
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
        Assert.assertTrue(myAccountFound, "My Account link was not found in the navigation bar");

        // Verify the title of the page after navigation
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class='uagb-ifb-title-wrap']"));
        System.out.println("The Title is: " + pageTitle.getText());
        Assert.assertEquals(pageTitle.getText(), "My Account");

        // Wait for the login button to be clickable
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")));
        loginButton.click();

        // Wait for the login fields to be visible and interactable
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_pass")));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("wp-submit")));

        // Input credentials and submit
        userName.sendKeys("root");
        password.sendKeys("pa$$w0rd");
        submitButton.click();

        // Wait for the logout button to appear after successful login
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ld-logout ld-logout ld-login-text ld-login-button ld-button']")));
        System.out.println("Is Logout Button Displaying: " + logoutButton.isDisplayed());

        // Assert that the logout button is displayed, confirming the login
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed, login might have failed.");
    }

    // Teardown function
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
