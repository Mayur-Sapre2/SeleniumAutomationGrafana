package com.selenium.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.constants.FrameworkConstants;


public class Driver {

	public static WebDriver driver;

	public static void initDriver() {
		if(Objects.isNull(driver)) { //it will avoid to relaucnh browser
			System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromeDriverpath()); 
			driver=new ChromeDriver();
			driver.get("http://www.google.com");
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(driver)) {
			driver.quit();
			driver=null;
		}
	}


}
