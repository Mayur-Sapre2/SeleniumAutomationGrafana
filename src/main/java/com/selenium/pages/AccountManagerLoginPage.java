package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enus.WaitStrategy;

public final class AccountManagerLoginPage extends Basepage {

	private final By txtBoxUsername=By.id("loginId");
	private final By btnContinue=By.id("submitBtn");
	private final By txtBoxpassword=By.id("password");
	private final By btnLogin=By.id("submitBtn");

	//Method chain
	
	public AccountManagerLoginPage enterUserName(String username) {
		sendkeys(txtBoxUsername, username, WaitStrategy.PRESENCE);
		return this;
	}
	
	public AccountManagerLoginPage clickContinue () {
		click(btnContinue, WaitStrategy.CLICKABLE);
		return this;
	}

	public AccountManagerLoginPage enterPassword(String password) {
		sendkeys(txtBoxpassword, password, WaitStrategy.PRESENCE);
		return this;
	}

	public ApplicationPanelPage clickLoginBtn() {
		click(btnLogin, WaitStrategy.CLICKABLE);
		return new ApplicationPanelPage();
	}
}
