package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.driver.DriverManager;
import com.selenium.enus.WaitStrategy;
import com.selenium.reports.ExtentLogger;

public class ApplicationPanelPage extends Basepage {
	
	ApplicationPanelPage() {
		
	}
	
	private final By textApplication_panel=By.xpath("//*[text()='Application Panel']");
	private final By textusername=By.id("xusername");
	private final By linkLogout=By.id("logout");
	private final By linkMy8x8=By.id("selfServiceSupport");
	private final By linkAdminConsole=By.id("cm-staging");
	private final By linkMeeting=By.id("smp_jitsi_admin_pilot");
	private final By linkSupport=By.id("support");
	
	public ApplicationPanelPage verifyApplicationPanelText() {
		DriverManager.getDriver().findElement(textApplication_panel).isDisplayed();
		return this;
	}
	
	public AccountManagerLoginPage logout() throws Exception {
		click(textusername, WaitStrategy.CLICKABLE," Username In Application Panel");
		click(linkLogout, WaitStrategy.CLICKABLE," Logout Button");
		return new AccountManagerLoginPage();
	}
	
	public AdminConsolePage clickOnAdminConsole() throws Exception {
		click(linkAdminConsole, WaitStrategy.PRESENCE,"Admin Console");
		switchToLatestOpenBrowser();
		return new AdminConsolePage();
	}
}
