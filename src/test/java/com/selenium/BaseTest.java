package com.selenium;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	
	@BeforeMethod
	protected void setup(Method m) throws Exception {
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown(ITestResult result) {
		Driver.quitDriver();
	}
}