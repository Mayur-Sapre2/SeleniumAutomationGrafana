package com.selenium;

import java.util.Map;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.selenium.annotations.FrameworkAnnotation;
import com.selenium.enus.Authors;
import com.selenium.enus.CategoryType;
import com.selenium.pages.AccountManagerLoginPage;
import com.selenium.reports.ExtentManager;
import com.selenium.utils.DeocdeUtils;

public class AdminConsolePageTest extends BaseTest {
	
	Faker faker=new Faker();

	private AdminConsolePageTest() {
		
	}
	
	@FrameworkAnnotation(author = {Authors.MAYUR_SAPRE,Authors.SUSIL_BEHERA}, category = {CategoryType.REGRESSION})
	@Test
	public void verifyNewUser(Map<String,String> data) throws Exception {
		new AccountManagerLoginPage().enterUserName(data.get("username"))
		.clickContinue()
		.enterPassword(data.get("password"))
		.clickLoginBtn()
		.verifyApplicationPanelText()
		.clickOnAdminConsole()
		.clickOnMenu(data.get("menu"))
		.createNewUser(data.get("firstname"),data.get("lastname"), data.get("primaryemail"));
	}
}
