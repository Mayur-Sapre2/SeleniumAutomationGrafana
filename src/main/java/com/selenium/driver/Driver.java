package com.selenium.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.selenium.enus.ConfigProperties;
import com.selenium.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

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
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				if(runmode.equalsIgnoreCase("remote")) {
					DesiredCapabilities cap=new DesiredCapabilities();
					cap.setBrowserName(BrowserType.CHROME);
					try {
						DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap));
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					DriverManager.setDriver(new ChromeDriver());
					DriverManager.getDriver().manage().window().maximize();
				}
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				if(runmode.equalsIgnoreCase("remote")) {
					DesiredCapabilities cap=new DesiredCapabilities();
					cap.setBrowserName(BrowserType.FIREFOX);
					try {
						DriverManager.setDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap));
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					DriverManager.setDriver(new FirefoxDriver());
					DriverManager.getDriver().manage().window().maximize();
				}
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
