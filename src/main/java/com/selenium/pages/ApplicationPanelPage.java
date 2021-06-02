package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;
import com.selenium.enus.WaitStrategy;
import com.selenium.reports.ExtentLogger;

public class ApplicationPanelPage extends Basepage {
	
	ApplicationPanelPage() {
		
	}
	
	private final By textApplication_panel=By.xpath("//*[text()='Application Panel']");
	private final By textusername=By.id("xusername");
	private final By linkLogout=By.id("logout");
	
	public ApplicationPanelPage verifyApplicationPanelText() {
		DriverManager.getDriver().findElement(textApplication_panel).isDisplayed();
		return this;
	}
	
	public AccountManagerLoginPage logout() throws Exception {
		click(textusername, WaitStrategy.CLICKABLE," Username In Application Panel");
		click(linkLogout, WaitStrategy.CLICKABLE," Logout Button");
		return new AccountManagerLoginPage();
	}
}
