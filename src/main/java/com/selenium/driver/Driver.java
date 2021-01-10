package com.selenium.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.constants.FrameworkConstants;

import com.selenium.utils.ReadPropertyFile;


public final class Driver {
	
	public Driver() {
		
	}

	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) { //it will avoid to relaucnh browser
			System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromeDriverpath()); 
			WebDriver driver=new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(ReadPropertyFile.get("url"));
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}


}
