package com.selenium.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.selenium.enus.ConfigProperties;
import com.selenium.exceptions.BrowserInvocationFailedException;
import com.selenium.factories.DriverFactory;
import com.selenium.utils.PropertyUtils;

/**
 * Driver class is repsonsible for invoking and closing the browsers.
 * 
 * <p>
 * It is also responsible 
 * for setting the driver variable to DriverManager which handles thread safety for webdriver instance.<p>
 * 
 * 
 * Jun 14, 2021
 * @author Mayur Sapre
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.selenium.BaseTest
 */

public final class Driver {
	/**
	 * Private constructor to avoid external instatntiation
	 */
	private Driver() {
		
	}
	/**
	 * 
	 * @author Mayur Sapre
	 * Jun 14, 2021
	 * @param browser value will be pass from {@link com.selenium.BaseTest}.Values: Chrome,Firefox
	 * 
	 */
	public static void initDriver(String browser) {
		String runmode=PropertyUtils.getValue(ConfigProperties.RUNMODE);
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			}
			catch(MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser invocation failed.Please check capabilities");
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
