package com.in;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity18 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/alerts");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        driver.findElement(By.id("simple")).click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        System.out.println("Text in alert: " + message);
        alert.accept();
        System.out.println(driver.findElement(By.id("result")).getText());
        
     // Close the browser
        driver.quit();
    }
}