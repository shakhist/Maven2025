package com.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://www.facebook.com/");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.findElement(By.linkText("Create new account")).click();
driver.findElement(By.name("firstname")).sendKeys("Nathan");
driver.findElement(By.name("lastname")).sendKeys("Stephen");
//driver.findElement(By.name("birthday_month")).click();
Select dropdown=new Select(driver.findElement(By.name("birthday_month")));
dropdown.selectByVisibleText("Nov");
//driver.findElement(By.name("birthday_day")).click();
Select drp1=new Select(driver.findElement(By.name("birthday_day")));
drp1.selectByValue("18");
Select drp2=new Select(driver.findElement(By.name("birthday_year")));
drp2.selectByValue("2013");
Thread.sleep(1000);
driver.close();
	}

}
