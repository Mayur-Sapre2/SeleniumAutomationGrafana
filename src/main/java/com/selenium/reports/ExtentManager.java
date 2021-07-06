package com.selenium.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> ext=new ThreadLocal();

	static ExtentTest getExtent() {
		return ext.get();
	}

	static void setExtent(ExtentTest extenttest) {
		ext.set(extenttest);
	}

	static void unload() {
		ext.remove();
	}

}
