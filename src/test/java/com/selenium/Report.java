package com.selenium;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	
	@Test
	public void attachLogo() throws IOException {
	ExtentReports extent=new ExtentReports();
	ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
	spark.loadXMLConfig(new File("extentconfig.xml"));
	extent.attachReporter(spark);
	
	ExtentTest test=extent.createTest("First Test");
	test.pass("test started");
	test.pass("test finish");
	test.assignAuthor("Mayur Sapre");
	test.assignCategory("Smoke");
	test.assignCategory("Regression");
	
	extent.flush();
	Desktop.getDesktop().browse(new File("index.html").toURI());
	}
}
