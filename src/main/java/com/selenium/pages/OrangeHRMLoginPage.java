package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;

public final class OrangeHRMLoginPage extends BasePage  {

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
		sendKeys(txt_username,uname);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String pass) {
		sendKeys(txt_password,pass);
		return this;
	}
	
	public OrangeHRMHomepage clickLogin() {
		click(loginbtn);
		return new OrangeHRMHomepage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}
	
}
