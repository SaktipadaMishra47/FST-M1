package com.in;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Activity9 {
	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
	WebDriver driver = new FirefoxDriver();
	// Open the page
	driver.get("https://training-support.net/webelements/keyboard-events");
	// Print the title of the page
	System.out.println("Page title: " + driver.getTitle());
	
	//*******************************************************************//
	Actions builder = new Actions(driver);
	builder.sendKeys("Hello this is Sakti here").pause(3000).sendKeys(Keys.RETURN).build().perform();
	WebElement result = driver.findElement(By.cssSelector("h1.mt-3"));
	System.out.println(" The result is  "+result.getText());
	
	//*******************************************************************//
			driver.quit();
		}
	}
