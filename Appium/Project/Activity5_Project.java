import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5_Project {

    public static void main(String[] args) {
        try {
            // Set desired capabilities for Appium and Chrome browser
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Android Emulator"); // Or use your device name
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("chromedriverExecutable", "/path/to/chromedriver"); // Adjust path as needed

            // Initialize AndroidDriver with Appium and open the URL
            AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.get("https://training-support.net");

            // Navigate to the login page
            MobileElement loginButton = driver.findElement(By.xpath("//android.widget.Button[@text='Login']"));
            loginButton.click();

            // Test with correct credentials
            loginTest(driver, "admin", "password");

            // Test with incorrect credentials
            loginTest(driver, "wronguser", "wrongpassword");

            // Close the session after the tests
            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to handle the login process
    public static void loginTest(AndroidDriver<MobileElement> driver, String username, String password) throws InterruptedException {
        // Fill out the login form
        MobileElement usernameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='username']"));
        usernameField.clear();
        usernameField.sendKeys(username);

        MobileElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

        MobileElement submitButton = driver.findElement(By.xpath("//android.widget.Button[@text='Log in']"));
        submitButton.click();

        // Wait for result to load
        Thread.sleep(2000);

        // Check if login was successful or not
        if (username.equals("admin") && password.equals("password")) {
            // Successful login
            MobileElement successMessage = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome Admin']"));
            if (successMessage.isDisplayed()) {
                System.out.println("Login successful with correct credentials.");
            }
        } else {
            // Failed login
            MobileElement errorMessage = driver.findElement(By.xpath("//android.widget.TextView[@text='Invalid credentials']"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Login failed with incorrect credentials.");
            }
        }
    }
}
