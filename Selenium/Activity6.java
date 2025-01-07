package com.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity6 {
	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		// Open the page
		driver.get("https://training-support.net/webelements/dynamic-controls");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkbox']"));
		if (!checkBox.isDisplayed()) {
			Thread.sleep(2000);
		} else {
			checkBox.click();
			checkBox.isSelected();
			System.out.println("Checkbox is clicked");
		}
		checkBox.click();
		checkBox.isSelected();
		System.out.println("Checkbox is clicked");
		driver.quit();
	}
}