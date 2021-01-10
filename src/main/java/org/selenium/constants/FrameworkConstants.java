package org.selenium.constants;

public final class FrameworkConstants {

	/*
	 * //we are not going to change chromedriverpath again an again,so 
	 * 1. we caN make it as final.
	 * 2. we will change access specifucer from public to private and set get and set methods.
	 * 3. i want that no one extends this classs so we will make it as final.  
	 * 4. ppl will create an object like new frameworkconstant() in loginpagettestclass,but we have all methods as static here,so we
	 *    can restrict them to not create object of this class by creating private constructor.
	 */
	
	private FrameworkConstants() {
		
	}
	
	private static final String RESOURCEPATH=System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH=RESOURCEPATH+"/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH=RESOURCEPATH+"/config/Framework.properties";
	
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeDriverpath() {
		return CHROMEDRIVERPATH;
	}
}
