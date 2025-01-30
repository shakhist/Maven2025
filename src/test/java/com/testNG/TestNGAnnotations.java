package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAnnotations {
  @Test
  public void testcase1() {
	  System.out.println("inside testcase1");
  }
  @Test
  public void testcase2() {
	  System.out.println("inside testcase2");

  }
  @Test
  public void testcase3() {
	  System.out.println("inside testcase3");

  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside before method");

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside after method");

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside before class");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside after class");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside before test");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside after test");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside before suite");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside after suite");
  }

}
