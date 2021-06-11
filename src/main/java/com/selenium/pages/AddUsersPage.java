package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enus.WaitStrategy;

public final class AddUsersPage extends Basepage{

	AddUsersPage() {
		
	}
	
	private final By textboxFirstName=By.xpath("//*[@name='basicInfo.firstName']");
	private final By textboxLastName=By.xpath("//*[@name='basicInfo.lastName']");
	private final By textboxPrimaryEmail=By.xpath("//*[@name='basicInfo.primaryEmail']");
	private final By dropdownSite=By.xpath("//*[@class='react-select__value-container css-1hwfws3']");
	private final By buttonSave=By.xpath("//*[text()='Save']");
	private final By dropdownSiteName=By.xpath("//*[text()='AA_Branch']");
	private final By linkCreateUser=By.xpath("//a[@data-id='CREATE_USER_INIT_CAP']");
	
	public AddUsersPage createNewUser(String firstname,String lastname,String primaryemail) throws Exception {
		sleep(10000);
		click(linkCreateUser, WaitStrategy.PRESENCE,"Create User");
		sendkeys(textboxFirstName, firstname, WaitStrategy.PRESENCE, "Firstname textbox");
		sendkeys(textboxLastName, lastname, WaitStrategy.PRESENCE, "Lastname textbox");
		sendkeys(textboxPrimaryEmail, primaryemail, WaitStrategy.PRESENCE, "Email textbox");
		click(dropdownSite, WaitStrategy.CLICKABLE, "Site Dropdown");
		click(dropdownSiteName, WaitStrategy.CLICKABLE, "AA_Branch Site");
		click(buttonSave, WaitStrategy.CLICKABLE, "Save Button");
		sleep(10000);
		return this;
	}
	 
}
