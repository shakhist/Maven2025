package com.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class testNG_ParallelExecution {
	@Parameters({"username"})
  @Test
  public void method1(String user) {
		System.out.println("inside method1 thread" +Thread.currentThread().getId());
	  System.out.println("inside method1"+user);
  }
	@Parameters({"Password"})
  @Test
  public void method2(String pwd) {
		System.out.println("inside method2 thread" +Thread.currentThread().getId());
	  System.out.println("inside method2"+pwd);
  }
  @Test
  public void method3() {
	  System.out.println("inside method3 thread"+Thread.currentThread().getId());
	  System.out.println("inside method3");
  }
  @Test
  public void method4() {
	  System.out.println("inside method4 thread"+Thread.currentThread().getId());
	  System.out.println("inside method4");
  }
  @Test
  public void method5() {
	  System.out.println("inside method5");
  }
  @AfterMethod
  public void afterMethod()
  {
	  System.out.println("inside after method");
  }
  @BeforeMethod
  public void Beforemethod()
  {
	  System.out.println("Inside before method");
  }
  
}
