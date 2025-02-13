package com.testNG;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNGLoadTest {
  @Test(invocationCount=3,threadPoolSize=5)
  public void LoadTest() {
	  Date dt=new Date(100);
	  SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
	  String times=sdf.format(dt);
	  System.out.println(times+"thread count is "+Thread.currentThread().getId());
  }
  @Test(invocationCount=10,threadPoolSize=10)
  public void LoadTest2()
  {
	  Date dt=new Date(100);
	  SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
	  String timestamp=sdf.format(dt);
	  System.out.println("inside second method");
	  System.out.println(timestamp+"thread count is "+Thread.currentThread().getId());
		 WebDriverManager.chromedriver().setup();

	  WebDriver driver=new ChromeDriver();
	 driver.get("https://www.google.com");
	 driver.quit();
	 
  }
}
