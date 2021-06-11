package com.selenium.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.selenium.constant.FrameworkConstant;

public final class DataProviderUtils {
	
	private static List<Map<String, String>> list=new ArrayList<>();
	
	@DataProvider
	public static Object[] getData(Method m) {
		String testname=m.getName();
		if(list.isEmpty()) {
			list=ExcelUtils.getTestDetails(FrameworkConstant.getDataSheet());
		}
		List<Map<String, String>> itr_list=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) &&
				list.get(i).get("execute").equalsIgnoreCase("yes")){
					itr_list.add(list.get(i));
				}
			}
		//list.removeAll(itr_list);
		return itr_list.toArray();
	}
} 