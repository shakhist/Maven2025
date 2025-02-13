package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testNG_DataProvider {
  @Test(priority=1,dataProvider="Shakhi")
  public void add(String user,String pwd,String email,String hobby) {
	  System.out.println("user " +user);
	  System.out.println("pwd " +pwd);
	  System.out.println("email " +email);
	  System.out.println("hobby " +hobby);
  }
  @Test(priority=2,dataProvider="Sikhil")
  public void check(int n1,int age)
  {
	  System.out.println("name is "+n1);
	  System.out.println("age is "+age);
  }
  @DataProvider
  public Object[][]Shakhi(){
	  return new Object[][] {
		  new Object[] {"user1","pwd1","email1","cricket"},
		  new Object[] {"user2","pwd2","email2","tennis"},
		  new Object[] {"user3","pwd3","email3","basketball"},

	  };
  }
	  @DataProvider
	  public Object[][]Sikhil(){
		  return new Object[][] {
			  new Object[] {5,4},
			  new Object[] {4,4},

		  };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
