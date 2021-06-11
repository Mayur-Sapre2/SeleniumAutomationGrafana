package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.epam.healenium.SelfHealingDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelfHeal {
	
	@Test
	public void selfHeal() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		SelfHealingDriver driver1=SelfHealingDriver.create(driver);
		driver1.get("http://www.google.com");
		driver1.manage().window().maximize();
		driver1.findElement(By.xpath("//*[text()='Gmail']")).click();	
	}
}