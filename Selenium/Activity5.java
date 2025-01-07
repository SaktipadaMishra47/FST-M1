package com.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity5 {
	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		// Open the page
		driver.get("https://training-support.net/webelements/dynamic-controls");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkbox']"));
		if (checkBox.isDisplayed()) {
			System.out.println("Checkbox is displyed");
		}
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		// Check if it is displayed on the page
		System.out.println("Checkbox displays: " + checkBox.isDisplayed());

		// Close the browser
		driver.quit();
	}
}