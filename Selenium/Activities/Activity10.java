package com.in;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Activity10 {
	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
	WebDriver driver = new FirefoxDriver();
	// Open the page
	driver.get("https://training-support.net/webelements/drag-drop");
	// Print the title of the page
	System.out.println("Page title: " + driver.getTitle());
	
	//*******************************************************************//
	Actions builder = new Actions(driver);
	WebElement ball = driver.findElement(By.id("ball"));
	WebElement drop1 = driver.findElement(By.id("dropzone1"));
	WebElement drop2 = driver.findElement(By.id("dropzone2"));
	
	WebElement text1 = driver.findElement(By.className("dropzone-text"));
	WebElement text2 = driver.findElement(By.className("dropzone-text"));
	
	builder.clickAndHold(ball).pause(4000).dragAndDrop(ball, drop1).release(drop1).build().perform();
	if(text1.getText() == "Dropped!") {
		System.out.println("Ball was dropped in Dropzone 2");
	}
	
	builder.dragAndDrop(drop1, drop2).pause(3000).build().perform();
	if(text2.getText() == "Dropped!") {
		System.out.println("Ball was dropped in Dropzone 1");
	}
	
	//*******************************************************************//
	driver.quit();
}
}
