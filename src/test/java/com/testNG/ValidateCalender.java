package com.testNG;

import org.testng.annotations.Test;

import com.Pages.MultipleWindowsPage;
import com.Pages.PractiseForm;
import com.Utilities.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateCalender extends Library {// Mouse operations done by Actions class

	@Test(priority = 1)
	public void verifycalender()
	{
		System.out.println("Inside verifycalender");
		driver.get(objProperties.getProperty("Practiseform"));
		PageLoadTimeOut();
		String title=driver.getTitle();
		Assert.assertEquals(title, objProperties.getProperty("Titleofcalenderpage"));
		
	}
	@Test(priority = 2)
	public void verifydropdowncalender()
	{
		System.out.println("verifydropdowncalender");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(PractiseForm.DateofBirth).click();
		WebElement month=driver.findElement(PractiseForm.month);
		Select objmonth=new Select(month);
		objmonth.selectByVisibleText(objProperties.getProperty("DOB_month"));
		WebElement year=driver.findElement(PractiseForm.year);
		Select Objyear=new Select(year);
		Objyear.selectByVisibleText(objProperties.getProperty("DOB_year"));
		//Set<String> Allwin=driver.getWindowHandles();
		//int a[]=new int[3];
		//a[0]=1;
		//int a[]= {1,2,3};
		List<WebElement> AllDays=driver.findElements(PractiseForm.Alldays);
		int numberofDays=AllDays.size();
		try {
		for(int i=0;i<numberofDays;i++)
		{
			String day=AllDays.get(i).getText();
			System.out.println(day);
			if(day.equals(objProperties.getProperty("DOB_Day")))
			{
				AllDays.get(i).click();
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			String DB=driver.findElement(PractiseForm.DOB).getAttribute("value");
			Assert.assertEquals(DB, objProperties.getProperty("DOB"));
		}
		
	}
	/*@Test(priority=3)
	public void verifyelements()
	{
		driver.findElement(null)
	}*/
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
		// WebDriverManager.chromedriver().setup();
		Library.LaunchBrowser();

	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}

	@BeforeSuite
	public void beforeSuite() {
		Library.ReadPropertiesFile();

	}

	@AfterSuite
	public void afterSuite() {
	}

}
