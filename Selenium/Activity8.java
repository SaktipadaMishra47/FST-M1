package com.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Activity8 {
	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
	WebDriver driver = new FirefoxDriver();
	// Open the page
	driver.get("https://training-support.net/webelements/mouse-events");
	// Print the title of the page
	System.out.println("Page title: " + driver.getTitle());
	
	//*******************************************************************//
	
	Actions builder = new Actions(driver);
	WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
    WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
    WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
    WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));
	builder.click(cargoLock).pause(2000).moveToElement(cargoToml).pause(3000).click().build().perform();
	WebElement result = driver.findElement(By.xpath("//strong[normalize-space()='clicked']"));
			
	String actionMessage = driver.findElement(By.id("result")).getText();
    System.out.println(actionMessage);
    builder.doubleClick(src).pause(3000).pause(3000).contextClick(target).pause(3000).build().perform();
    // and then open it
    builder.click(driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"))).pause(3000).build().perform();
    // Print the front side text
    actionMessage = driver.findElement(By.id("result")).getText();
    System.out.println(actionMessage);
	//*******************************************************************//
		driver.quit();
	}
}