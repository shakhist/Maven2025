package com.testNG;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import com.Selenium.openBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;

public class testng_OpenBrowser {
  @Test(invocationCount=2)
  public void tearDown() {
      //tearDown
	  WebDriver driver;
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://www.google.com");
			driver.manage().window().maximize();
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
