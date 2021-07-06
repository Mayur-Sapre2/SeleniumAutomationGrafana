package com.selenium;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.JSONException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.gurock.testrail.APIException;
import com.selenium.driver.Driver;
import com.selenium.utils.ELKUtils;
import com.selenium.utils.TestRail;

public class BaseTest {
	
	protected String testCaseId;
	
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
	protected void tearDown(ITestResult result) throws IOException, APIException, JSONException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			TestRail.addResultForTestCase(testCaseId, TestRail.TEST_CASE_PASSED_STATUS, "");
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			TestRail.addResultForTestCase(testCaseId, TestRail.TEST_CASE_FAILED_STATUS, result.getName().toString());
		}
		Driver.quitDriver();
	}
}