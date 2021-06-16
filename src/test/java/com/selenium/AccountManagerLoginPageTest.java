package com.selenium;

import java.util.Map;

import org.testng.annotations.Test;

import com.selenium.listeners.RetryFailedTest;
import com.selenium.pages.AccountManagerLoginPage;
import com.selenium.utils.DataProviderUtils;
import com.selenium.utils.DeocdeUtils;

public class AccountManagerLoginPageTest extends BaseTest {

	private AccountManagerLoginPageTest() {
		
	}
	
	@Test
	public void loginlogoutTest(Map<String,String> data) throws Exception {		
		//ExtentReport.createTest("loginLogoutTest");
		new AccountManagerLoginPage(). enterUserName(data.get("username"))
				.clickContinue()
				.enterPassword(data.get("password"))
				.clickLoginBtn()
				.verifyApplicationPanelText()
				.logout();
	}
	
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

