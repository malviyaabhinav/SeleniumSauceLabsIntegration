package com.qa.tests;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.BasePageSauceLabs;
import com.qa.pages.HubSpotLoginPage;
import com.qa.util.Constant;

public class LoginPageRemoteTest {
	
	BasePageSauceLabs basePage;
	RemoteWebDriver driver;
	Properties property;
	HubSpotLoginPage loginPage;
	
	
	
	@BeforeMethod
	@Parameters("executionMode")
	public void setUp(String executionMode) throws MalformedURLException {
		basePage =new BasePageSauceLabs();
		property =basePage.readSaucelabProperty();
		
		if(executionMode.equalsIgnoreCase("android")) {
			driver =basePage.initiateRemoteDriverAndroid();
		}
		else if(executionMode.equalsIgnoreCase("desktop")) {
			driver = basePage.initiateRemoteDriverDesktop();
		}
		else if(executionMode.equalsIgnoreCase("iOS")){
			driver = basePage.initiateRemoteDriveriOS();
			
		}
	//	driver =basePage.initiateRemoteDriverAndroid();
	//	driver = basePage.initiateRemoteDriverDesktop();
	//	driver = basePage.initiateRemoteDriveriOS();
			loginPage =new HubSpotLoginPage(driver);	
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
		driver.quit();
	}
	
	

}
