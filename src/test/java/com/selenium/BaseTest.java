package com.selenium;

import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.selenium.driver.Driver;
import com.selenium.utils.ELKUtils;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	
	@BeforeSuite
	protected void deleteElasticSearchIndex() {
		ELKUtils.deleteDetailsToELK();
	}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setup(Object[] data) throws Exception {
		Map<String,String> map=(Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"),map.get("version"));
	}

	@AfterMethod
	protected void tearDown(ITestResult result) {
		Driver.quitDriver();
	}
}