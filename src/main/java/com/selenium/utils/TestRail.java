/**
 * 
 */
package com.selenium.utils;

/**
 * Jun 30, 2021
 * @author Mayur Sapre
 * @version 1.0
 * @since 1.0
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
//import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRail {

	public static String TEST_RUN_ID                = "63352";
	public static String TESTRAIL_USERNAME          = "platform-services-dev@8x8.com";
	public static String TESTRAIL_PASSWORD          = "pa55WOrd";
	public static String RAILS_ENGINE_URL           = "http://tr.8x8.com/";
	public static final int TEST_CASE_PASSED_STATUS = 1;
	public static final int TEST_CASE_FAILED_STATUS = 5;
	WebDriver driver;

	/*
	 * @Test(description =
	 * "Verify that Title appearing on the webpage is as expected.") public void
	 * verifyTitle() throws Exception{ WebDriverManager.chromedriver().setup();
	 * WebDriver driver=new ChromeDriver(); driver.get("https://www.google.co.in");
	 * String actualTilte = driver.getTitle(); if (actualTilte.contains("Google")) {
	 * Assert.assertTrue(actualTilte.contains("Google"));
	 * TestRail.addResultForTestCase("10072366", TEST_CASE_PASSED_STATUS, ""); }
	 * else{ TestRail.addResultForTestCase("10072366", TEST_CASE_FAILED_STATUS, "");
	 * }
	 * 
	 * driver.quit(); }
	 */


	public static void  addResultForTestCase(String testCaseId, int status,
			String screenshotPath) throws IOException, APIException, JSONException{

		String testRunId = TEST_RUN_ID;

		APIClient client = new APIClient(RAILS_ENGINE_URL);
		client.setUser(TESTRAIL_USERNAME);
		client.setPassword(TESTRAIL_PASSWORD);
		Map data = new HashMap();
		data.put("status_id", status);
		data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
		data.put("elapsed", "2m 45s");
		client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"", data);
	}
}
