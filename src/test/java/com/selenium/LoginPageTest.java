package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.selenium.driver.Driver;

public final class LoginPageTest extends BaseTest {
	
	private LoginPageTest() {
		// TODO Auto-generated constructor stub
	}
	
	//Never Hardcode
	//keep right thing at right place.
	
	@Test
	public void openBrowser() {
		/*
		 * here we can extends ths Frameworkconstant class,but we can extends only one
		 * class and we want to extend basepage class here so we declare
		  * frameworkconstant class as final.
		 */
		
		/*
		 * new FrameworkConstants(); this will give error becasue we are restricting
		 * user to not create object of the class by declaring private cons.
		 */
		Driver.driver.findElement(By.name("q")).sendKeys("Mayur",Keys.ENTER);
	}
	
	@Test
	public void testBrowser() {
		Driver.driver.findElement(By.name("q")).sendKeys("Sapre",Keys.ENTER);
	}
}
