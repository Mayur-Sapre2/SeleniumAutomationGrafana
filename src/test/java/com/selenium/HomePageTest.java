package com.selenium;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.selenium.driver.Driver;
import com.selenium.driver.DriverManager;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {

	}

	@Test
	public void testHomepage() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing", Keys.ENTER);
	}
	
	/*
	 * 1.validate whether title contains Google Search or google search. 
	 * 2. validate whether title is not null and len. of title is greater than 12 and less than
	 * 100. 
	 * 3. check for link in page 
	 * 4. no. of links displayed is exactly 10 or 15.
	 */
	
	@Test
	public void testHomepageTest() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing Mini Bytes - YouTube", Keys.ENTER);
		String title=DriverManager.getDriver().getTitle();
		
		//Assertj Way
		assertThat(title)
			.as("Title is null").isNotNull()
			.containsIgnoringCase("google search")
			.hasSizeBetween(15, 100);
			
		/*
		 * //TestNG Way
		 * Assert.assertTrue(Objects.nonNull(title));
		 * Assert.assertTrue(title.toLowerCase().contains("google search"));
		 * Assert.assertTrue(title.length()>15); Assert.assertTrue(title.length()<100);
		 */
		
		
		List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//h3/span"));
		
		//AssertJ
		assertThat(elements)
			.hasSize(10)
			.extracting(e->e.getText())//extract webele. and convert into text
			.contains("Testing Mini Bytes - YouTube");
		
		/*
		 * //TestNG Way
		 *  Assert.assertEquals(elements.size(),10); boolean
		 * isElementPresent=false; for(WebElement element:elements) {
		 * if(element.getText().equalsIgnoreCase("Testing Mini Bytes - YouTube")) {
		 * isElementPresent=true; break; } }
		 * Assert.assertTrue(isElementPresent,"Testing mini bytes not found");
		 */
	}
}
