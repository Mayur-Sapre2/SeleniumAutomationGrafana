package com.selenium.listeners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.selenium.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		try {
			List<Map<String, String>> list=ExcelUtils.getTestDetails("RUNMANAGER");
			List<IMethodInstance> result=new ArrayList<>();
			for(int i=0;i<methods.size();i++) {
				for(int j=0;j<list.size();j++) {
					if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))) {
						if(list.get(j).get("execute").equalsIgnoreCase("yes")) {
							methods.get(i).getMethod().setDescription((list.get(j).get("testdescription")));
							methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
							methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
							result.add(methods.get(i));
						}
					}
				}
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
