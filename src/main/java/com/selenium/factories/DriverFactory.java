/**
 * 
 */
package com.selenium.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.selenium.driver.DriverManager;
import com.selenium.enus.ConfigProperties;
import com.selenium.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Jun 16, 2021
 * @author Mayur Sapre
 * @version 1.0
 * @since 1.0
 */
public final class DriverFactory {

	private DriverFactory() {

	}

	public static WebDriver getDriver(String browser,String version) throws MalformedURLException {
		WebDriver driver=null;
		String runmode=PropertyUtils.getValue(ConfigProperties.RUNMODE);
		if(browser.equalsIgnoreCase("chrome")) {
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				cap.setVersion(version);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
			else{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			if(runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				cap.setVersion(version);
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			}
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}

		return driver;
	}
}
