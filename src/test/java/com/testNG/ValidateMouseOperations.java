package com.testNG;

import org.testng.annotations.Test;

import com.Utilities.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

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

public class ValidateMouseOperations extends Library {// Mouse operations done by Actions class

	// public WebDriver driver;
	public WebElement el;
	Actions ac;

	@Test(priority = 1)
	public void pageload() {
		driver.get(objProperties.getProperty("mouseoperations"));
		PageLoadTimeOut();// or classname.method name
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "jQuery contextMenu (2.x)");
	}

	@Test(priority = 2, enabled = false)
	public void ValidateMouseclickOperations() throws InterruptedException {
		ac = new Actions(driver);
		System.out.println("validate mouse click operations");
		el = driver.findElement(By.xpath("//span[contains(text(),'click me')]"));
		ac.contextClick(el).build().perform();

		// System.out.println("validate mouse click operations");
		el = driver.findElement(By.xpath("//span[text()='Edit']"));
		ac.click(el).build().perform();
		Thread.sleep(5000);

		Alert al = driver.switchTo().alert();
		Assert.assertEquals(al.getText(), "clicked: edit");
		al.accept();
		el = driver.findElement(By.xpath("//span[contains(text(),'click me')]"));
		ac.contextClick(el).build().perform();
		el = driver.findElement(By.xpath("//span[text()='Paste']"));
		ac.click(el).build().perform();
		Thread.sleep(1000);
		al = driver.switchTo().alert();
		Assert.assertEquals(al.getText(), "clicked: paste");
		al.accept();
	}

	@Test(priority = 3)
	public void VerifyrightclickOperations() {
		driver.navigate().to(objProperties.getProperty("doubleclickOperations"));
		Library.PageLoadTimeOut();
		String title = driver.getTitle();
		Assert.assertEquals(title, "dblclick event | jQuery API Documentation");
	}

	@Test(priority = 4)
	public void verifydoubleclick() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,2500)");
		WebElement frame = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(0);
		el = driver.findElement(By.xpath("//span[contains(text(),'Double click')]/preceding-sibling::div"));
		ac = new Actions(driver);
		ac.doubleClick(el).build().perform();
		// System.out.println(el.getAttribute("background-color"));
		// el=wait.until
	}

	@Test(priority=5)
  public void VerifyDragandDrop()
  {
		System.out.println("inside verify drag and drop");
		driver.navigate().to(objProperties.getProperty("mouseDragandDrop"));
		PageLoadTimeOut();
		WebElement frame = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame);
		el = driver.findElement(By.id("draggable"));
		ac = new Actions(driver);
		WebElement el1 = driver.findElement(By.id("droppable"));
		ac.dragAndDrop(el, el1).build().perform();
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
