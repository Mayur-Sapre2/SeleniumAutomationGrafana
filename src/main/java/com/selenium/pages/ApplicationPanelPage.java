package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;

public class ApplicationPanelPage {
	
	ApplicationPanelPage() {
		
	}
	
	private final By textApplication_panel=By.xpath("//*[text()='Application Panel']");
	private final By textusername=By.id("xusername");
	private final By linkLogout=By.id("logout");
	
	public ApplicationPanelPage verifyApplicationPanelText() {
		DriverManager.getDriver().findElement(textApplication_panel).isDisplayed();
		return this;
	}
	
	public AccountManagerLoginPage logout() {
		DriverManager.getDriver().findElement(textusername).click();
		DriverManager.getDriver().findElement(linkLogout).click();
		return new AccountManagerLoginPage();
	}
	
	
	
	

}
