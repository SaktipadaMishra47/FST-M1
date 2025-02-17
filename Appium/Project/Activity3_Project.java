package fst.appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3_Project {
	// Driver Declaration
	AndroidDriver driver;
	WebDriverWait wait;

	// Set up method
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page in Chrome
		driver.get("https://training-support.net/webelements/lazy-loading");
	}
	
	@Test
    public void additionTest() {
	WebElement inputField = driver.findElement(By.id("inputFieldId")); 
    inputField.sendKeys("Buy groceries");

    WebElement addButton = driver.findElement(By.id("addButtonId")); 
    addButton.click();

    
    WebElement todoItem = driver.findElement(By.xpath("//li[contains(text(),'Buy groceries')]"));
    if (todoItem.isDisplayed()) {
        System.out.println("Todo item added successfully!");
    } else {
        System.out.println("Failed to add todo item.");
    }

    // Close the browser session
    driver.quit();

          }
}
