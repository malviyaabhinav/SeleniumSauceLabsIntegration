package com.qa.tests;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePageLocal;
import com.qa.base.BasePageSauceLabs;
import com.qa.pages.HubSpotLoginPage;
import com.qa.pages.HubSpotLoginPageLocal;
import com.qa.util.Constant;

public class LoginPageLocalTest {
	BasePageLocal basePage;
	WebDriver driver;
	Properties property;
	HubSpotLoginPageLocal loginPage;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		basePage =new BasePageLocal();
		property =basePage.getProperty();
		//driver =basePage.initiateRemoteDriverAndroid();
		driver = basePage.initiateDriverLocal();
		loginPage =new HubSpotLoginPageLocal(driver);	
	}
	
	@Test(priority=1)
	public void validateTitle() {
		String title=loginPage.getTitle();
		System.out.println("The page title is: "+title);
		Assert.assertEquals(title, Constant.HUBSPOT_LOGIN_PAGE_TITLE);
	}
	
	
	  @Test(priority=2) public void validateSignUpLinkDisplayed() {
	  Assert.assertTrue(loginPage.signUpDisplayed()); }
	  
	  
	  @Test(priority=3) public void validateLogin() {
	  loginPage.doLogin(property.getProperty("username"),
	  property.getProperty("password")); }
	 	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
		System.out.println("Test Case complete");
	}
	
	

}
