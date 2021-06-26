/**
 * 
 */
package com.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

/**
 * Jun 16, 2021
 * @author Mayur Sapre
 * @version 1.0
 * @since 1.0
 */
public class DockerTest {

	@Test(dataProvider = "getData")
	public void dockerTest(String browser,String version) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setVersion(version);
		cap.setBrowserName(browser);
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://www.google.com");
		System.out.println("Title is"+driver.getTitle());
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		driver.quit();
	}
	
	@DataProvider(parallel = true)
	public Object[][] getData(){
		return new Object[][] {{"chrome","91.0.4472.77"},{"chrome","79.0.3945.117"},{"firefox","89.0"},{"firefox","89.0"}};
	}
		
}
