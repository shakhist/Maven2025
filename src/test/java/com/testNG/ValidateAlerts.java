package com.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pages.AlertsPage;
import com.Utilities.Library;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlerts extends Library {
	Alert al;
  @Test(priority=1)
  public void ValidateNormalAlerts() {
	  driver.get(objProperties.getProperty("Alerts"));
	  PageLoadTimeOut();
	  System.out.println(driver.getTitle());
	  driver.findElement(AlertsPage.NormalAlert).click();
	   al=driver.switchTo().alert();
	  String alert1=al.getText();
	  Assert.assertEquals(alert1, "You clicked a button");
	  al.accept();
  }
  @Test(priority=2)
  public void TimerAlert()
  {
	  JavascriptExecutor jse=(JavascriptExecutor)driver;
	  jse.executeScript("window.scroll(0,250)");
	  driver.findElement(AlertsPage.TimerAlert).click();
	  //Thread.sleep(5000);
	  WebDriverWait wait=new WebDriverWait(driver,60); //Explicit wait applicable for only one web element.
	  //it will wait until expected condition is met
	  wait.until(ExpectedConditions.alertIsPresent());
	  al=driver.switchTo().alert();
	  System.out.println(al.getText());
	  Assert.assertEquals(al.getText(),"This alert appeared after 5 seconds");
	  	  	al.accept();
	  
	  	
  }
  @Test(priority=3)
  public void promptAlert()
  {
	  driver.findElement(AlertsPage.promptbutton).click();
		al=driver.switchTo().alert();
		al.sendKeys("I am learning alerts");
		al.accept();
		String result=driver.findElement(By.id("promptResult")).getText();
		//Assert.assertEquals(result, "You entered i am ");
		SoftAssert objSAssert=new SoftAssert();
		
  }
  @Test(priority=4)
  public void confirmAlert()
  {
	  driver.findElement(AlertsPage.confirmAlert).click();
		al =driver.switchTo().alert();
		System.out.println(al.getText());
		SoftAssert objSAssert=new SoftAssert();
		objSAssert.assertEquals(al.getText(), "Do you confirm action?");
		al.dismiss();
		String a=driver.findElement(By.id("confirmResult")).getText();

		objSAssert.assertEquals(a, "You selected Cancel");
		objSAssert.assertAll();//validate all soft asserts.else we wont know if any asserts failed
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
	  LaunchBrowser();

  }

  @AfterTest
  public void afterTest() {
	//  driver.close();
  }

  @BeforeSuite
  public void beforeSuite() {
	  ReadPropertiesFile();
  }

  @AfterSuite
  public void afterSuite() {
  }

}
