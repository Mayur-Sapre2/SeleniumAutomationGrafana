package com.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {
		
	}

	@BeforeMethod
	public void setUp() {
		Driver.initDriver();
	}

	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
}
