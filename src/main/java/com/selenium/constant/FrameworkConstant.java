package com.selenium.constant;

public class FrameworkConstant {
	
	private FrameworkConstant(){
		
	}
	
	private static final String BASEPATH=System.getProperty("user.dir")+"\\src\\test\\resources\\";
	private static final String CHROMEDRIVERPATH=BASEPATH+"/executables/chromedriver.exe";
	private static final String CONFIGPATH=BASEPATH+"/config/config.properties";
	private static final int EXPLICITWAIT=10;
	
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
