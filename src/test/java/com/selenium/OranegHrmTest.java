package com.selenium;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.selenium.pages.OrangeHRMHomepage;
import com.selenium.pages.OrangeHRMLoginPage;

public final class OranegHrmTest extends BaseTest {

	private OranegHrmTest(){
		
	}
	
	@Test
	public void loginlogouttest() {
		String title=new OrangeHRMLoginPage()
				.enterUsername("Admin").enterPassword("admin123").clickLogin()
				.clickWelcome().clickLogout().getTitle();
		Assertions.assertThat(title)
			.isEqualTo("OrangeHRM");
		
	}
}
