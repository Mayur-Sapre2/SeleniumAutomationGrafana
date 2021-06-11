package com.selenium.pages;

import org.openqa.selenium.By;
import com.selenium.enus.WaitStrategy;
import com.selenium.utils.DynamicXpathUtils;

public final class AdminConsolePage extends Basepage {
	
	AdminConsolePage() {
		
	}
	
	private final By linkUsers=By.xpath("//*[text()='Add & manage users']");
	private final By linkPhoneNumbers=By.xpath("//*[text()='Phone numbers']");
	private final By linkDevices=By.xpath("//*[text()='Devices']");
	private final By linkLicenses=By.xpath("//*[text()='Licenses']");
	private final By linkCompany=By.xpath("//*[text()='Company']");
	private final By linkAPIKeys=By.xpath("//*[text()='API Keys']");
	private final By linkRecordings=By.xpath("//*[text()='Recordings']");
	private final By linkTranscriptionPolicy=By.xpath("//*[text()='Transcription Policy']");
	
	private String linkMenu="//*[text()='%s']";
	
	public AddUsersPage clickOnMenu(String menu) throws Exception {
		String newxpath=DynamicXpathUtils.getXpath(linkMenu, menu);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE,menu);
		if(menu.contains("user")) {
			return new AddUsersPage();
		}
		return null;
	}
}
