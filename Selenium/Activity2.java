package com.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		System.out.println("Tile is : "+driver.getTitle());
		driver.findElement(By.xpath("//input[@type= 'text'][@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type= 'password'][@name='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class= 'svelte-1pdjkmx']")).click();
	    driver.quit();
		
	}
}
