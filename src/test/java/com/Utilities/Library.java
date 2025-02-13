package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	public static Properties objProperties;
	public static WebDriver driver;
	
	public static void ReadPropertiesFile() {
		System.out.println("location of project:" + System.getProperty("user.dir"));
		File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//config.Properties");
		//get propert - gives the location where project is stored
		FileInputStream ObjInputStream;//input stream for reading file
		try {
			ObjInputStream = new FileInputStream(objFile);
			objProperties = new Properties();
			// objProperties.lo
			objProperties.load(ObjInputStream);//loads config file
			System.out.println(objProperties.getProperty("browser"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LaunchBrowser() {
		String browserFromPropertiesFile = objProperties.getProperty("browser");
		switch (browserFromPropertiesFile) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			break;
		}
System.out.println("browser launched");
		driver.manage().window().maximize();
		// Implicit Wait : Global waiting mechanism applicable for all webElements in a
		// web page //All Pages
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static void PageLoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

}
