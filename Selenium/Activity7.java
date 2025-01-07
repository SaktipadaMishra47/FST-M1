package com.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity7 {
	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		// Open the page
		driver.get("https://training-support.net/webelements/dynamic-controls");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		WebElement textInput = driver.findElement(By.xpath("//*[@id='textInput']"));
		WebElement enbleInputButton = driver.findElement(By.xpath("//*[@id='textInputButton']"));
		if(!textInput.isEnabled()) {
			enbleInputButton.click();
			textInput.sendKeys("Testing the enablement");
			Thread.sleep(3000);
		}
		else {
			System.out.println("Button is not enabled");
		}
		System.out.println(textInput.getDomProperty("value"));

        // Close the browser
        driver.quit();
	}
}