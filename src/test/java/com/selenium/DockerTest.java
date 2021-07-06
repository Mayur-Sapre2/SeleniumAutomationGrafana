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
	/*
	 * @Test public void dockerTest() throws MalformedURLException {
	 * DesiredCapabilities cap=new DesiredCapabilities();
	 * cap.setBrowserName(BrowserType.CHROME); cap.setCapability("enableVNC", );
	 * cap.setCapability("enableVideo", true); cap.setCapability("videoName",
	 * "Test Video"); WebDriver driver=new RemoteWebDriver(new
	 * URL("http://localhost:4444/wd/hub"),cap);
	 * driver.get("http://www.google.com");
	 * System.out.println("Title is"+driver.getTitle());
	 * Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS); driver.quit(); }
	 */
}
