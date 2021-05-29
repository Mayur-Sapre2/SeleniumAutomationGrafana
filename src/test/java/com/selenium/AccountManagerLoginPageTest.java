package com.selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.AccountManagerLoginPage;

public class AccountManagerLoginPageTest extends BaseTest {

	private AccountManagerLoginPageTest() {
		
	}
	
	@Test(dataProvider = "LoginData")
	public void loginlogoutTest(String username,String password) {		
		new AccountManagerLoginPage(). enterUserName(username)
				.clickContinue()
				.enterPassword(password)
				.clickLoginBtn()
				.verifyApplicationPanelText()
				.logout();
	}
	
	@DataProvider(name="LoginData")
	public Object[][] getData(){
		return new Object[][] {
			{"QATHOR1005MIG","ThorMigration@12345"},
			{"mayur.sapre","Test@123"}
		};
	}
	
}

