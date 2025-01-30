package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utilities.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateFrames extends Library {
//public static WebDriver driver;
static WebElement el;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ReadPropertiesFile();
LaunchBrowser();
driver.get(objProperties.getProperty("FramesURL"));
//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
 el=driver.findElement(By.id("singleframe"));
driver.switchTo().frame(el);
driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("shakhi");//xpath locates the element uniquely
driver.switchTo().defaultContent();
driver.findElement(By.linkText("Iframe with in an Iframe")).click();
el=driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
driver.switchTo().frame(el);
el=driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
driver.switchTo().frame(el);
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("shakhi");
Thread.sleep(1000);
driver.close();
	}

}
