package liveProject;

import dev.failsafe.Timeout;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleTasks {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        //Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @Test
    public void CreateGoogleTasks(){
        //Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        //Wait for the new task element
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        //Enter the details
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        //Save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Add 2nd task
        //Find and click the add button
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AppiumBy.id("com.google.android.apps.tasks:id/task_name")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        //Enter the details
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keeps");
        //Save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Add 3rd task
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        //Enter the details
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        //Save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Assertions
        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google Keep']"));
        String taskName = tasks.get(0).getText();
        Assert.assertEquals(taskName, "Complete the second Activity Google Keep");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
