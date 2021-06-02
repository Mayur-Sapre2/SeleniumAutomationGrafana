package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enus.WaitStrategy;
import com.selenium.factories.ExplicitWaitFactory;
import com.selenium.reports.ExtentLogger;

public class Basepage {

	protected void click(By by,WaitStrategy waitstrategy,String elementname) throws Exception {
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).click();
		ExtentLogger.pass(elementname + " is clicked",true);
	}
	
	protected void sendkeys(By by,String text,WaitStrategy waitstrategy,String elementname) throws Exception {
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(text);
		ExtentLogger.pass(text + " is entered successfully in "  + elementname,true);
	}	
}
