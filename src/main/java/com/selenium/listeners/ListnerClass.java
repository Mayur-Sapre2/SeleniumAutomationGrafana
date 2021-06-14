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
	}

	@Override
	public void onTestFailure(ITestResult result) {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed" + result.getThrowable().toString(),true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
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
