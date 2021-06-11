package com.selenium.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.selenium.constant.FrameworkConstant;
import com.selenium.enus.ConfigProperties;

public final class PropertyUtils {

	private PropertyUtils() {
		
	}
	
	private static Properties prop=new Properties();
	private static final Map<String,String> CONFIGMAP=new HashMap();
	
	static {
		try(FileInputStream fis=new FileInputStream(FrameworkConstant.getConfigpath())) {
			prop.load(fis);
			for(Map.Entry<Object, Object> entry: prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(ConfigProperties key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
			throw new Exception("Property Name " + key + "is not found.Please check in config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
