package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.selenium.driver.Driver;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {

	}

	@Test
	public void testHomepage() {
		Driver.driver.findElement(By.name("q")).sendKeys("Testing", Keys.ENTER);
	}
}
