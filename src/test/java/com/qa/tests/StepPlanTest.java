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
import com.qa.pages.StepPlan;
import com.qa.util.Constant;

public class StepPlanTest {
	BasePageSauceLabs basePage;
	RemoteWebDriver driver;
	Properties property;
	StepPlan stepPlan;
	
	
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
		stepPlan =new StepPlan(driver);	
	}
	
	@Test(priority=1)
	public void validateTitle() {
		String title=stepPlan.getTitle();
		System.out.println("The page title is: "+title);
		Assert.assertEquals(title, Constant.STEPPLAN_PAGE_TITLE);
	}
	
	  @Test(priority=2)
	  public void validateGuideLink() {
		  stepPlan.clickOnTiles();
		  Assert.assertEquals(stepPlan.isGuideLinkPresent(), true);
	  }
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}



















