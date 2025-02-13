package com.testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class Parallel_TC2 {
  @Test
  public void method1() {
	  System.out.println("inside TC2_method1 "+Thread.currentThread().getId());
	  System.out.println("inside TC2_method1");
  }
  @Test
  public void method2()
  {
	  System.out.println("inside TC2_method2 "+Thread.currentThread().getId());

	  System.out.println("inside TC2_method2");
  }
  @Test
  public void method3()
  {
	  System.out.println("inside TC2_method3 "+Thread.currentThread().getId());

	  System.out.println("inside TC2_method3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside before method "+Thread.currentThread().getId());

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside after method "+Thread.currentThread().getId());

  }

  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver=new EdgeDriver();
	  driver.get("http://www.google.com");
	  System.out.println("inside before class TC2 "+Thread.currentThread().getId());
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside after class TC2"+Thread.currentThread().getId());

  }

}
