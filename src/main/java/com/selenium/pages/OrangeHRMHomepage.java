package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.driver.DriverManager;

public class OrangeHRMHomepage {

	private final By link_welcome=By.xpath("//*[@id='welcome']");
	private final By link_logout=By.xpath("//a[text()='Logout']");

	public OrangeHRMHomepage clickWelcome() {
		DriverManager.getDriver().findElement(link_welcome).click();
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(link_logout));
		DriverManager.getDriver().findElement(link_logout).click();
		return new OrangeHRMLoginPage();
	}
}

