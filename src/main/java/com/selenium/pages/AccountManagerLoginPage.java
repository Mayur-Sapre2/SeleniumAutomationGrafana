package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enus.WaitStrategy;
import com.selenium.reports.ExtentLogger;

public final class AccountManagerLoginPage extends Basepage {

	private final By txtBoxUsername=By.id("loginId");
	private final By btnContinue=By.id("submitBtn");
	private final By txtBoxpassword=By.id("password");
	private final By btnLogin=By.id("submitBtn");

	//Method chain
	
	public AccountManagerLoginPage enterUserName(String username) throws Exception {
		sendkeys(txtBoxUsername, username, WaitStrategy.PRESENCE,"Username Textbox");
		return this;
	}
	
	//username enetered successfully: 
	
	public AccountManagerLoginPage clickContinue () throws Exception {
		click(btnContinue, WaitStrategy.CLICKABLE,"Continue button");
		return this;
	}

	public AccountManagerLoginPage enterPassword(String password) throws Exception {
		sendkeys(txtBoxpassword, password, WaitStrategy.PRESENCE,"Password Textbox");
		return this;
	}

	public ApplicationPanelPage clickLoginBtn() throws Exception {
		click(btnLogin, WaitStrategy.CLICKABLE,"Login Button");
		return new ApplicationPanelPage();
	}
}
