package com.testNG;

import org.testng.annotations.Test;

import com.Pages.MultipleWindowsPage;
import com.Utilities.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMultipleWindows extends Library {// Mouse operations done by Actions class

	// public WebDriver driver;
	public WebElement el;
	Actions ac;

	@Test(priority = 1)
	public void pageload() {
		driver.get(objProperties.getProperty("nxtgenaiacademyURL"));
		PageLoadTimeOut();// or classname.method name
		String title = driver.getTitle();
		System.out.println("title is "+title);
		Assert.assertEquals(title, objProperties.getProperty("nxtgenaiacademytitle"));
	}
	@Test(priority=2)
	public void verifyWindowHandle()
	{
		driver.findElement(MultipleWindowsPage.newBrowserWindow).click();
		String parentWin=driver.getWindowHandle();
		Set<String> AllWindows = driver.getWindowHandles();
		for (String InvWindow : AllWindows) {
			
			driver.switchTo().window(InvWindow);

			//int hsh = InvWindow.hashCode();
			String title = driver.getTitle();
			if (title.equals(objProperties.getProperty("newBrowserWindowtitle"))) {

				driver.findElement(MultipleWindowsPage.Menu).click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,800)");
				System.out.println(title);
				// driver.findElement(MultipleWindowsPage.AboutMe).click();
				driver.close();
			}
			//System.out.println("hashcode is " + hsh);
			
			System.out.println(title);
			

		}
		driver.switchTo().window(parentWin);
	}
	@Test(priority=3)
	public void newmessageWindow() throws InterruptedException
	{
		
		System.out.println("new title is "+driver.getTitle());
		driver.findElement(MultipleWindowsPage.newMessagewindow).click();
		String parentwin=driver.getWindowHandle();
		Set<String> AllWin=driver.getWindowHandles();
		for(String Invwin:AllWin)
		{
			driver.switchTo().window(Invwin);
			//System.out.println(Invwin.hashCode());
			//System.out.println("inside new message window"+driver.getTitle());
			//Thread.sleep(1000);
			//driver.close();
		}
		driver.close();
		driver.switchTo().window(parentwin);
	}
@Test(priority=5)
public void browsertab()
{
	driver.findElement(MultipleWindowsPage.Newbrowsertab).click();
	String parentwin=driver.getWindowHandle();
	System.out.println("inside browsertab"+driver.getTitle());
	
	Set<String> AllWin=driver.getWindowHandles();
	for (String Invwin:AllWin)
	{	
		driver.switchTo().window(Invwin);
		String t1 = driver.getCurrentUrl();
		System.out.println("current url is " + t1);
		if (t1.contains("webtable")) {
			System.out.println("t is " + t1);
			driver.findElement(MultipleWindowsPage.name1).sendKeys("John Doe");
		}
		
	}
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
