package com.testNG;

import org.testng.annotations.Test;

import com.Pages.Webtable;
import com.Utilities.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class WebTable extends Library {
  @Test(priority=1)
  public void Webtable1() {
	  driver.get(objProperties.getProperty("webtableurl"));
	  PageLoadTimeOut();
	  System.out.println("inside webtable1");
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProperties.getProperty("webtabletitle"));
  }
  @Test(priority=2)
  public void Verifytableinfo() throws InterruptedException
  {
	  System.out.println("inside verify table info");
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,400)");
	  Thread.sleep(3000);
	  List<WebElement> last=driver.findElements(Webtable.Lastnames);
	  int ls=last.size();
	  System.out.println(ls);
	  for(int i=0;i<ls;i++)
	  {
		  //System.out.println("hello");
		  String lastname=last.get(i).getText();
		  System.out.println("lastnames are "+lastname);
		  if(last.get(i).getText().equals(objProperties.getProperty("lname")))
		  {
			  
			String firstname=  driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+(i+1)+"]/td[2]")).getText();
			System.out.println("firstname is "+firstname);
			String position=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+(i+1)+"]/td[4]")).getText();
			System.out.println("position is " +position);
			String office=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+(i+1)+"]/td[5]")).getText();
			System.out.println("office is "+office);
			String Startdt=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+(i+1)+"]/td[6]")).getText();
			System.out.println("start date is "+Startdt);
			String Salary=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+(i+1)+"]/td[7]")).getText();
			System.out.println("Salary is "+Salary);
			
		  }	  
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside afterClass(");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside beforeTest");
	  Library.LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
	  Library.ReadPropertiesFile();
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside afterSuite");
  }

}
