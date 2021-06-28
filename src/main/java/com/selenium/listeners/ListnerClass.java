package com.selenium.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.selenium.annotations.FrameworkAnnotation;
import com.selenium.reports.ExtentLogger;
import com.selenium.reports.ExtentReport;
import com.selenium.utils.ELKUtils;

public class ListnerClass implements ITestListener,ISuiteListener {

	@Override
	public void onTestStart(ITestResult result) {
		//BeforeMethod
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed");
		ELKUtils.sendDetailsToELK(result.getMethod().getDescription(),"pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed" + result.getThrowable().toString(),true);
		ELKUtils.sendDetailsToELK(result.getMethod().getDescription(),"fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
		ELKUtils.sendDetailsToELK(result.getMethod().getDescription(),"skip");
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ITestContext context) {
			ExtentReport.flushReports();
	}
	
}
