package com.selenium.stepdefinition;

import java.util.Map;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;
import com.selenium.utils.ExcelReaderFillo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepDefinition {

//	@Given("read test data for testcase_(\\d+)$")
//	public void read_test_data_for_tescase(Map<String,String> data) {
//		List<Map<String, String>> a=ExcelUtils.getTestDetails("test");
//		System.out.println(a.iterator());
//		
//	}
	@Given("^read test data for testcase_(\\d+)$")
	public void read_test_data_for_testcase_(int arg1) throws Throwable 
	{
		Map<String,String> map=ExcelReaderFillo.getTestDataInMap(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\Testdata.xlsx", "DATA", "TestCase_00"+arg1+"");
		System.out.println(map.get("firstname"));
	}
	
	@When("user enters username")
	public void enterUsername() {
		DriverManager.getDriver().get("https://sso.8x8pilot.com/v2/login");
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().findElement(By.id("loginId")).sendKeys("MAYURSAPRE");
	}
}