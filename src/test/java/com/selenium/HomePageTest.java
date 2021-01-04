package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

	@Test
	public void testHomepage() {
		driver.findElement(By.name("q")).sendKeys("Testing",Keys.ENTER);
	}
}
