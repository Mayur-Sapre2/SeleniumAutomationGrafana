package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;

public final class OrangeHRMLoginPage {

	/*
	 * id 
	 * name 
	 * classname 
	 * linktext 
	 * partiallinktext 
	 * css/xpath
	 */
	
	private final By txt_username=By.id("txtUsername");
	private final By txt_password=By.xpath("//*[@id='txtPassword' and @type='password']");
	private final By loginbtn=By.id("btnLogin");
	
	public OrangeHRMLoginPage enterUsername(String uname) {
		DriverManager.getDriver().findElement(txt_username).sendKeys(uname);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String pass) {
		DriverManager.getDriver().findElement(txt_password).sendKeys(pass);
		return this;
	}
	
	public OrangeHRMHomepage clickLogin() {
		DriverManager.getDriver().findElement(loginbtn).click();
		return new OrangeHRMHomepage();
	}
	
	public String getTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
}
