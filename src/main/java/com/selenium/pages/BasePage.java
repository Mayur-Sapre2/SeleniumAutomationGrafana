package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.driver.DriverManager;

public class BasePage {

	protected void click(By by,String waitstrategy) {
		if(waitstrategy.equalsIgnoreCase("presence")) {
			explicitlywaitforelementtobepresent(by);
		} else if (waitstrategy.equalsIgnoreCase("clickable")) {
			explicitlywaitforelementtobeclickable(by);
		}
		DriverManager.getDriver().findElement(by).click();
	}
	
	protected void sendKeys(By by,String value,String waitstrategy) {
		if(waitstrategy.equalsIgnoreCase("presence")) {
			explicitlywaitforelementtobepresent(by);
		} else if (waitstrategy.equalsIgnoreCase("clickable")) {
			explicitlywaitforelementtobeclickable(by);
		}
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	private void explicitlywaitforelementtobeclickable(By by) {
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	private void explicitlywaitforelementtobepresent(By by) {
		new WebDriverWait(DriverManager.getDriver(), 10)
		.until(ExpectedConditions.presenceOfElementLocated(by));
	}
}
