package com.selenium;

import java.util.Map;

import org.testng.annotations.Test;

import com.selenium.annotations.FrameworkAnnotation;
import com.selenium.enus.Authors;
import com.selenium.enus.CategoryType;
import com.selenium.listeners.RetryFailedTest;
import com.selenium.pages.AccountManagerLoginPage;
import com.selenium.utils.DataProviderUtils;
import com.selenium.utils.DeocdeUtils;

public class AccountManagerLoginPageTest extends BaseTest {

	private AccountManagerLoginPageTest() {
		
	}
	
	@FrameworkAnnotation(author = {Authors.MAYUR_SAPRE,Authors.SUSIL_BEHERA}, category = {CategoryType.REGRESSION})
	@Test
	public void loginlogoutTest(Map<String,String> data) throws Exception {		
		//ExtentReport.createTest("loginLogoutTest");
		testCaseId="10072366";
		new AccountManagerLoginPage().enterUserName(data.get("username"))
				.clickContinue()
				.enterPassword(data.get("password"))
				.clickLoginBtn()
				.verifyApplicationPanelText()
				.logout();
	}
	
	@FrameworkAnnotation(author = {Authors.MAYUR_SAPRE,Authors.SUSIL_BEHERA}, category = {CategoryType.REGRESSION})
	@Test
	public void newtest(Map<String,String> data) throws Exception {		
		//ExtentReport.createTest("loginLogoutTest");
		new AccountManagerLoginPage(). enterUserName(data.get("username"))
				.clickContinue()
				.enterPassword(data.get("password"))
				.clickLoginBtn()
				.verifyApplicationPanelText()
				.logout();
	}
}

