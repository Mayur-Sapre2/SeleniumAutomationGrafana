package com.selenium.pages;

import java.util.Iterator;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;
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
	
	protected void switchToLatestOpenBrowser() {
		Iterator<String> handleIterator = DriverManager.getDriver().getWindowHandles().iterator();
		while (handleIterator.hasNext())
		{
			String handle = handleIterator.next();
			if (!handleIterator.hasNext())
			{
				DriverManager.getDriver().switchTo().window(handle);
				ExtentLogger.pass("Switched to new browser window");
			}
		}
	}
	
	protected void sleep(Integer seconds) {
        long secondsLong = (long) seconds;
        try {
            Thread.sleep(secondsLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
