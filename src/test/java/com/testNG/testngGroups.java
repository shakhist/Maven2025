package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class testngGroups {
  @Test(groups= {"functional"})
  public void method1() {
	  System.out.println("inside functional tc");
  }
@Test(groups= {"regression"})
public void method2() {
	System.out.println("inside regression tc");
}
@Test(groups= {"sanity"})
public void method3() {
	System.out.println("inside sanity tc");
}
@Test(groups= {"functional","sanity"})
public void method4() {
	System.out.println("this is funciotnal and sanity");
}
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside after method");
  }

}
