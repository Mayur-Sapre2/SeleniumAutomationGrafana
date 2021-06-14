package com.selenium.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.selenium.driver.DriverManager;
import com.selenium.enus.ConfigProperties;
import com.selenium.utils.PropertyUtils;
import com.selenium.utils.ScreenshotUtil;

public final class ExtentLogger {

	private ExtentLogger() {

	}
	public static void pass(String message) {
		ExtentManager.getExtent().pass(message);
	}
	public static void fail(String message) {
		ExtentManager.getExtent().fail(message);
	}
	public static void skip(String message) {
		ExtentManager.getExtent().skip(message);
	}
	
	public static void pass(String message,boolean isScreenshotneed) throws Exception {
		if(PropertyUtils.getValue(ConfigProperties.PASSEDTESTSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotneed) {
			ExtentManager.getExtent().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message,boolean isScreenshotneed){
		if(PropertyUtils.getValue(ConfigProperties.FAILEDTESTSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotneed){
			ExtentManager.getExtent().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
		}else {
			fail(message);
		}
	}
	
	public static void skip(String message,boolean isScreenshotneed) throws Exception {
		if(PropertyUtils.getValue(ConfigProperties.SKIPTESTSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotneed) {
			ExtentManager.getExtent().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
		}else {
			skip(message);
		}
	}
}
