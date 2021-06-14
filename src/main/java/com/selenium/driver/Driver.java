package com.selenium.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.constant.FrameworkConstant;
import com.selenium.enus.ConfigProperties;
import com.selenium.utils.PropertyUtils;

public final class Driver {
	
	private Driver() {
		
	}

	public static void initDriver(String browser) {
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",FrameworkConstant.getChromedriverpath());
				DriverManager.setDriver(new ChromeDriver());
				DriverManager.getDriver().manage().window().maximize();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",FrameworkConstant.getGeckodriverpath());
				DriverManager.setDriver(new FirefoxDriver());
				DriverManager.getDriver().manage().window().maximize();
			}
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
