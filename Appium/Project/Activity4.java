package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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

public class Activity4 {

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

	@Test
	public void addTasksTest() {
		driver.get("https://v1.training-support.net/selenium");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .70));
		Point end = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .48));

		// Perform swipe
		ActionsBase.doSwipe(driver, start, end, 50);

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))
				.sendKeys("Add tasks to list");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View[1]")));

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))
				.sendKeys("Get number of tasks");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View[2]")));

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))
				.sendKeys("Clear the list");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View[3]")));

		List<WebElement> taskList = driver
				.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']//android.view.View"));

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();

		taskList = driver
				.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']//android.view.View"));

		Boolean isPassed = false;
		if (taskList.size() == 2) {
			System.out.println("Cleared all the tasks");
			isPassed = true;
		}
		Assert.assertTrue(isPassed);
	}

	// Tear down function
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
