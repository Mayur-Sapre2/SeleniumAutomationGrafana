package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.driver.DriverManager;

public class OrangeHRMHomepage extends BasePage{

	private final By link_welcome=By.xpath("//*[@id='welcome']");
	private final By link_logout=By.xpath("//a[text()='Logout']");

	public OrangeHRMHomepage clickWelcome() {
		click(link_welcome);
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(link_logout));
		click(link_logout);
		return new OrangeHRMLoginPage();
	}
}

