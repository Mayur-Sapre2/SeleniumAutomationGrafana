package com.selenium.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constant.FrameworkConstant;
import com.selenium.enus.ConfigProperties;
import com.selenium.utils.PropertyUtils;

public final class Driver {
	
	private Driver() {
		
	}

	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver",FrameworkConstant.getChromedriverpath());
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			DriverManager.setDriver(driver);
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
