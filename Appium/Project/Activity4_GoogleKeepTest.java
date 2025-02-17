package fst.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity4_GoogleKeepTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Set up the desired capabilities
    	
   	
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator"); // Modify if using a real device
        capabilities.setCapability("platformVersion", "11"); // Change as per your device version
        capabilities.setCapability("appPackage", "com.google.android.keep"); // Google Keep package
        capabilities.setCapability("appActivity", "com.google.android.keep.activities.MainActivity"); // Google Keep activity
        capabilities.setCapability("noReset", true); // Don't reset app data
        capabilities.setCapability("automationName", "UiAutomator2"); // For Android

        // Launch the Appium server
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Create a new note
        MobileElement createNoteButton = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Create note']"));
        createNoteButton.click();

        // Wait for the note text area to load
        Thread.sleep(2000); // Adjust as necessary

        // Add text to the note
        MobileElement noteInput = (MobileElement) driver.findElement(By.id("com.google.android.keep:id/edit_note_text"));
        noteInput.sendKeys("My Automated Note with a Reminder!");

        // Open the reminder options
        MobileElement reminderButton = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Reminder']"));
        reminderButton.click();

        // Set the reminder to a specific time (e.g., 5 PM)
        MobileElement timeOption = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Pick time']"));
        timeOption.click();

        // Wait for the time picker
        Thread.sleep(2000); // Adjust as necessary

        // Set a specific time (example: 5:00 PM)
        MobileElement timePicker = (MobileElement) driver.findElement(By.id("com.android.deskclock:id/timepicker"));
        timePicker.sendKeys("5:00 PM"); // This may need adjustment based on your device's behavior

        // Save the note with the reminder
        MobileElement saveButton = (MobileElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Save']"));
        saveButton.click();

        // Wait for the note to be saved
        Thread.sleep(3000); // Adjust as necessary

        // Close the driver session
        driver.quit();

        System.out.println("Note with reminder added successfully!");
    }
}
