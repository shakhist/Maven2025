package com.testNG;

import org.testng.annotations.Test;

import com.Utilities.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testngParameters extends Library {//class 14/10/2022
	@Parameters({"BrowserName"})
  @Test(priority=1)
  public void Openbrowser(String Bro) {
		System.out.println("Inside browser");
		System.out.println(Bro);
		WebDriver driver=null;
		if(Bro.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (Bro.equalsIgnoreCase("edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
		}
		else
			{System.out.println("firefox browser");
			WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
  }
	
	@Parameters({"username","password"})
	@Test(priority=2)
	public void signin(String username,String password)
	{
		System.out.println("inside signin");
		System.out.println(username+password);
		
	}
	@Parameters({"email"})
	@Test(priority=3)
	public void email(String email)
	{
		System.out.println("inside email");
		System.out.println(email);
	}
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }
@Parameters({"BrowserName1"})
  @BeforeSuite
  public void beforeSuite(String Browser) {
	 // ReadPropertiesFile();
	System.out.println("Inside before suite");
	System.out.println("browser at suite level is "+Browser);
  }

  @AfterSuite
  public void afterSuite() {
  }

}
