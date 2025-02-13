package com.testNG;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class testNG_Factory {
	private String param="";//instance variable
	public testNG_Factory(String param)
	{
		this.param=param;
		System.out.println("parameter is "+this.param);
	}
	
  @Test
  public void method1() {
	  System.out.println("second method"+param);
  }
  @Test
  public void method2()
  {
	  System.out.println("no parameters");
  }
  @Test
  public void method3()
  {
	  System.out.println("third method is "+param);
  }
  @Factory
  public Object[]Shakhi(){
	  return new Object[] {
			  new testNG_Factory("hello"),// constructor will initialize instance variable
			  new testNG_Factory("susann"),
			  new testNG_Factory("snehaa")
	  };
	  }
  }

