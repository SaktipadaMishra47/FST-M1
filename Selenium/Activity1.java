package com.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net");
		System.out.println("Tile is : "+driver.getTitle());
		driver.findElement(By.linkText("About Us")).click();
		System.out.println("Tile after clicking is  : "+driver.getTitle());
	    driver.quit();
		
	}
}
