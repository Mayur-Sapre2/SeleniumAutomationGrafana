package com.selenium.constant;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.selenium.enus.ConfigProperties;
import com.selenium.utils.PropertyUtils;

public class FrameworkConstant {
	
	private FrameworkConstant(){
		
	}
	
	private static final String BASEPATH=System.getProperty("user.dir")+"\\src\\test\\resources\\";
	private static final String CHROMEDRIVERPATH=BASEPATH+"/executables/chromedriver.exe";
	private static final String CONFIGPATH=BASEPATH+"/config/config.properties";
	private static final int EXPLICITWAIT=10;
	private static final String EXTENTREPORTPATH=System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath="";
	private static String EXCELPATH=BASEPATH+"/excel/Testdata.xlsx";
	private static String RUNMANAGERSHEET="RUNMANAGER";
	
	private static String DATASHEET="DATA";
	
	
	public static String getRunManagerSheet() {
		return RUNMANAGERSHEET;
	}
	
	public static String getDataSheet() {
		return DATASHEET;
	}

	public static String getExcelPath() {
		return EXCELPATH;
	}

	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}
	
	private static String createReportPath() throws Exception {
		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORT).equalsIgnoreCase("no")) {
			String timestamp=new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");
			return EXTENTREPORTPATH+timestamp+"/index.html";
			//return EXTENTREPORTPATH+System.currentTimeMillis()+"/index.html";
		}else {
			return EXTENTREPORTPATH+"/index.html";
		}
	}
	
	/*
	 * public static String getExtentreportpath() throws Exception {
	 * if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORT).equalsIgnoreCase(
	 * "yes")) { return
	 * EXTENTREPORTPATH+"/"+System.currentTimeMillis()+"index.html"; } else { return
	 * EXTENTREPORTPATH+"/"+"index.html"; } }
	 */
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	public static String getConfigpath() {
		return CONFIGPATH;
	}
}
