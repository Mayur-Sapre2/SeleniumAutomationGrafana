package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;

public class BasePage {

	protected void click(By by) {
		DriverManager.getDriver().findElement(by).click();
	}
	
	protected void sendKeys(By by,String value) {
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
