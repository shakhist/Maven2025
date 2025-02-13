package com.Selenium;

import java.util.concurrent.TimeUnit;
//import 

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.AlertsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class toolsQA_Alerts {

	static WebDriver driver;
	static Alert al;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
driver =new ChromeDriver();
driver.get("https://demoqa.com/alerts");
driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);//Page load timeout
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//implicit wait is a global waiting mechanism which is applicable for all web elements.it is going to
//wait until the duration is reached.
driver.manage().window().maximize();
System.out.println(driver.getTitle());
driver.findElement(AlertsPage.NormalAlert).click();
 al=driver.switchTo().alert();
System.out.println(al.getText());
al.accept();
JavascriptExecutor jse=(JavascriptExecutor)driver;
jse.executeScript("window.scroll(0,250)");
driver.findElement(AlertsPage.TimerAlert).click();
//Thread.sleep(5000);
WebDriverWait wait=new WebDriverWait(driver,60); //Explicit wait applicable for only one web element.
//it will wait until expected condition is met
wait.until(ExpectedConditions.alertIsPresent());
al=driver.switchTo().alert();
System.out.println(al.getText());
if (al.getText().equalsIgnoreCase("This alert appeared appeared after 3 seconds"))
{
	al.accept();
}
else 
	System.out.println("Timer alert is not validated");
	al.dismiss();
	
	driver.findElement(AlertsPage.confirmAlert).click();
	al =driver.switchTo().alert();
	System.out.println(al.getText());
	al.dismiss();
	String a=driver.findElement(By.id("confirmResult")).getText();

	if(a.equalsIgnoreCase("You selected ok"))
	{
		System.out.println("Action is confirmed");
	}
	else
		System.out.println("Action is not confirmed");
	driver.findElement(AlertsPage.promptbutton).click();
	al=driver.switchTo().alert();
	al.sendKeys("I am learning alerts");
	al.accept();
	String result=driver.findElement(By.id("promptResult")).getText();
	if (result.equalsIgnoreCase("You entered i am "))
	{
		System.out.println("confirm is validated");
	}
	else
		System.out.println("Confirm result is not validated");
	Thread.sleep(1000);
	driver.close();

}
}
