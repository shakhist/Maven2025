package com.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowser {

	public WebDriver driver;
	public static void main(String[] args) {
		openBrowser obj=new openBrowser();
		WebDriverManager.chromedriver().setup();
		obj.driver=new ChromeDriver();
		obj.driver.get("http://www.google.com");
		obj.driver.manage().window().maximize();
		//System.out.println();
		
//driver=new ChromeDriver();
	}

}
