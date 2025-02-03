package com.testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AcceptedW3CCapabilityKeys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMouseOperations {//Mouse operations done by Actions class
	public WebDriver driver;
Actions ac;
public WebElement el;
	@Test(priority = 1)
	public void pageload() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "jQuery contextMenu (2.x)");
	}
  @Test(priority=2)
  public void ValidateMouseclickOperations() throws InterruptedException {
	  ac =new Actions(driver);
	  System.out.println("validate mouse click operations");
	   el=driver.findElement(By.xpath("//span[contains(text(),'click me')]"));
	  ac.contextClick(el).build().perform();
  
	  
		//System.out.println("validate mouse click operations");
		 el = driver.findElement(By.xpath("//span[text()='Edit']"));
		ac.click(el).build().perform();
		Thread.sleep(5000);

		Alert al = driver.switchTo().alert();
		Assert.assertEquals(al.getText(), "clicked: edit");
		al.accept();
		el=driver.findElement(By.xpath("//span[contains(text(),'click me')]"));
	ac.contextClick(el).build().perform();
	el=driver.findElement(By.xpath("//span[text()='Paste']"));
	ac.click(el).build().perform();
	Thread.sleep(1000);
	al=driver.switchTo().alert();
	Assert.assertEquals(al.getText(), "clicked: paste");
}
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
		driver.close();
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
