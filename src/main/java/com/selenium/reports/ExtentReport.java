package com.selenium.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.constant.FrameworkConstant;
import com.selenium.enus.Authors;
import com.selenium.enus.CategoryType;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extent;
	public static ExtentTest test;

	public static void initReports() throws Exception {
		if(Objects.isNull(extent)) {
			extent=new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstant.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Provisioning Report");
			spark.config().setReportName("Account Manager");
		}
	}

	public static void flushReports() throws Exception {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentReportFilePath()).toURI());
	}

	public static void createTest(String testcasename) {
		test=extent.createTest(testcasename);
		ExtentManager.setExtent(test);
	}
	
	public static void addAuthors(Authors[] authors) {
		for(Authors temp:authors) {
			ExtentManager.getExtent().assignAuthor(temp.toString());
		}
	}
	
	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp:categories) {
			ExtentManager.getExtent().assignCategory(temp.toString());
		}
	}
}
