package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {

	// Declare driver
	AppiumDriver driver;
	WebDriverWait wait;

	// Setup function
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverUrl = new URI("http://localhost:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverUrl, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	@Test(priority = 1)
	public void validLoginTest() {
		driver.get("https://v1.training-support.net/selenium");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .70));
		Point end = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .55));

		// Perform swipe
		ActionsBase.doSwipe(driver, start, end, 100);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")));

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")));

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.widget.TextView[@resource-id='action-confirmation']")));

		String loginSuccess = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='action-confirmation']")).getText();

		Assert.assertEquals(loginSuccess, "Welcome Back, admin");
	}

	@Test(priority = 2)
	public void invalidLoginTest() {
		driver.get("https://v1.training-support.net/selenium");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .70));
		Point end = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .55));

		// Perform swipe
		ActionsBase.doSwipe(driver, start, end, 100);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")));

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']")));

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("username");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.widget.TextView[@resource-id='action-confirmation']")));

		String loginFailed = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='action-confirmation']")).getText();

		Assert.assertEquals(loginFailed, "Invalid Credentials");
	}

	// Tear down function
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
