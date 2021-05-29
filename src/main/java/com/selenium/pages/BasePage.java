package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enus.WaitStrategy;
import com.selenium.factories.ExplicitWaitFactory;

public class Basepage {

	protected void click(By by,WaitStrategy waitstrategy) {
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).click();
	}
	
	protected void sendkeys(By by,String text,WaitStrategy waitstrategy) {
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(text);
	}	
}
