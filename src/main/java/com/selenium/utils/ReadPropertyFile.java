package com.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.selenium.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private ReadPropertyFile() {
		
	}
	
	private static Properties prop=new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<>();
	
	static {
		try {
			FileInputStream fis=new FileInputStream(FrameworkConstants.getConfigfilepath() );
			prop.load(fis);
			for(Map.Entry<Object, Object> entry:prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))){
			throw new Exception("Property name " +key +" is not found. please check framework.properties");
		}
		return CONFIGMAP.get(key);
	}
	
//	public static String getValue(String key) throws Exception {
//		if(Objects.isNull(prop.getProperty(key)) || Objects.isNull(key)) {
//			throw new Exception("Property name " +key +" is not found. please check framework.properties");
//		}
//		return prop.getProperty(key);		
//	}
}
