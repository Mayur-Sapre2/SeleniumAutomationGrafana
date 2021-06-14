package com.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.constant.FrameworkConstant;
import com.selenium.exceptions.FrameworkException;
import com.selenium.exceptions.InvalidExcelPathException;

public final class ExcelUtils {

	private ExcelUtils() {
		
	}
	
	//Try with Resoures
	public static List<Map<String,String>> getTestDetails(String sheetname){
		List<Map<String,String>> list = null;
		try(FileInputStream fs = new FileInputStream(FrameworkConstant.getExcelPath())) {

			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			Map<String,String> map =null;
			list = new ArrayList<>();

			for(int i=1; i<=lastrownum;i++) { 
				map = new HashMap<>(); 
				for(int j=0;j<lastcolnum;j++) {
					String key= sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			throw new InvalidExcelPathException("Excel file not found");
		} catch (IOException e) {
			throw new FrameworkException("some IO exception found while reading file");
		}
		System.out.println(list);
		return list;
	}
	
	

}