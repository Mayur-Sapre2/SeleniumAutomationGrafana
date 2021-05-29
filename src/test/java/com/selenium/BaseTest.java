package com.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {
		
	}

	@BeforeMethod
	protected void setup() throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
		//multithread part need to check
	}
}