package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.driver.DriverManager;

public class OrangeHRMHomepage extends BasePage{

	private final By link_welcome=By.xpath("//*[@id='welcome']");
	private final By link_logout=By.xpath("//a[text()='Logout']");

	public OrangeHRMHomepage clickWelcome() {
		click(link_welcome,"clickable");
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		click(link_logout,"clickable");
		return new OrangeHRMLoginPage();
	}
}

