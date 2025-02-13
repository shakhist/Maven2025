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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ParallelTestSuite2 {
	String testname="";
	@BeforeTest
	  @Parameters({"test-name"})
	  public void beforeTest(String testname) {
		  this.testname=testname;
		  System.out.println(testname);

		  System.out.println("inside TC2 before test "+Thread.currentThread().getId());

	  }
  @Test
  public void method1() {
	  System.out.println(testname);

	  System.out.println("inside TC2 method1 "+Thread.currentThread().getId());
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println(testname);

	  System.out.println("inside TC2 beforeMethod "+Thread.currentThread().getId());

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println(testname);

	  System.out.println("inside TC2 after method "+Thread.currentThread().getId());

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(testname);

	  System.out.println("inside TC2 before class "+Thread.currentThread().getId());

  }

  @AfterClass
  public void afterClass() {
	  System.out.println(testname);

	  System.out.println("inside TC2 after class "+Thread.currentThread().getId());

  }

  

  @AfterTest
  public void afterTest() {
	  System.out.println(testname);
	  System.out.println("inside TC2 after test "+Thread.currentThread().getId());

  }

  /*@BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.edgedriver().setup();
	  WebDriver driver=new EdgeDriver();
	  driver.get("https://www.google.com");
	  System.out.println(testname);

	  System.out.println("inside TC2 before suite "+Thread.currentThread().getId());

  }

  @AfterSuite
  public void afterSuite() {
	 
	  System.out.println(testname);

	  System.out.println("inside TC2 after suite "+Thread.currentThread().getId());

  }*/

}
