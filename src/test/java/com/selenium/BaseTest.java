package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.constants.FrameworkConstants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromeDriverpath()); 
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
