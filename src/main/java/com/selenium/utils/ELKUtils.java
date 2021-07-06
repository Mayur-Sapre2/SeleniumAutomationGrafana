package com.selenium.utils;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.selenium.enus.ConfigProperties;

import io.restassured.response.Response;

/**
 * Mar 11, 2021 
 * @author Amuthan Sakthivel
 * @version 1.0
 * @since 1.0
 */
public class ELKUtils {

	private ELKUtils() {
		
	}
	
	public static void sendDetailsToELK(String testname,String status) {
		if(PropertyUtils.getValue(ConfigProperties.SENDRESULTOKIBANA).equalsIgnoreCase("yes")){
		Map<String,String> map=new HashMap<>();
		map.put("testname", testname);
		map.put("status", status);
		//map.put("module", "test");
		map.put("author", "Mayur Sapre");
		map.put("executimontime", LocalDateTime.now().toString());
		
		Response response=given().header("Content-Type","application/json")
		.log()
		.all()
		.body(map)
		.post(PropertyUtils.getValue(ConfigProperties.ELASTICSEARCHURL));
		
		Assert.assertEquals(response.statusCode(), 201);
		response.prettyPrint();
		}
	}
	
	public static void deleteDetailsToELK() {
		if(PropertyUtils.getValue(ConfigProperties.SENDRESULTOKIBANA).equalsIgnoreCase("yes")){
		
		Response response=given()
		.delete(PropertyUtils.getValue(ConfigProperties.ELASTICSEARCHDELETEURL));
		
		Assert.assertEquals(response.statusCode(), 200);
		response.prettyPrint();
		}
	}
}