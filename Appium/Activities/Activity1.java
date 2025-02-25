package activities;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static activities.ActionsBase.doSwipe;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class Activity1 {
AndroidDriver driver;
@BeforeClass
public void setUp() throws MalformedURLException, URISyntaxException {
    // Desired Capabilities
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName("android");
    options.setAutomationName("UiAutomator2");
    options.setAppPackage("com.android.calculator2");
    options.setAppActivity(".Calculator");
    options.noReset();

    // Server Address
    URL serverURL = new URI("http://localhost:4723").toURL();

    // Driver Initialization
    driver = new AndroidDriver(serverURL, options);
}
 // Test method
    @Test
    public void multiplyTest() {
        // Perform the calculation
    	driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
    	driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
    	driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
    	driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
    	String result=driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
    	Assert.assertEquals(result, "25");
    	
    }
    
 // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}


