package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.selenium.driver.Driver;
import com.selenium.driver.DriverManager;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {

	}

	@Test
	public void testHomepage() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing", Keys.ENTER);
	}
	
	@Test
	public void testHomepageTest() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Sapre", Keys.ENTER);
	}
}
