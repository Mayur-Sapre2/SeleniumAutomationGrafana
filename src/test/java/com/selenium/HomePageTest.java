package com.selenium;

import java.util.List;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.driver.DriverManager;

public final class HomePageTest extends BaseTest{
	
	private HomePageTest() {
		
	}
	
	@Test
	public void test1() throws Exception {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("New",Keys.ENTER);
		String title=DriverManager.getDriver().getTitle();
		
		Assertions.assertThat(title)
				.isNotNull()
				.as("not contain expected text").containsIgnoringCase("New")
				.matches("\\w.*"+"New")
				.hasSizeBetween(15,100);
				
		List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//h3/span"));
		Assertions.assertThat(elements)
				.hasSize(10)
				.extracting(e->e.getText())
				.contains("New");
	}

	/*@Test
	public void test1() throws Exception {
		//MyScreenRecorder.startRecording("Selenium Recorder");
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("New",Keys.ENTER);
		//MyScreenRecorder.stopRecording();
		String title=DriverManager.getDriver().getTitle();
		Assert.assertTrue(Objects.nonNull(title),"Title is Null");
		Assert.assertTrue(title.toLowerCase().contains("google search"));
		Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search"));
		Assert.assertTrue(title.length()>15);
		Assert.assertTrue(title.length()<100);
		List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//h3/span"));
		Assert.assertEquals(elements.size(),1);
		boolean isElementPresent=false;
		for(WebElement element: elements) {
			if(element.getText().equalsIgnoreCase("New")) {
				isElementPresent=true;
				break;
			}
		}
		*/
}
