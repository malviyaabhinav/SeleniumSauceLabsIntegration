package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.base.BasePageSauceLabs;
import com.qa.util.Constant;
import com.qa.util.ElementActionRemote;

public class StepPlan extends BasePageSauceLabs {
	
	RemoteWebDriver driver;
	ElementActionRemote elementAction;
	
	public StepPlan(RemoteWebDriver driver) {
		this.driver =driver;
		elementAction = new ElementActionRemote(this.driver);
	}
	
	By technicalSupport =By.xpath("//div[@id='tech-support']");
	By tv =By.xpath("//div[@id='Television']");
	By upcTV =By.xpath("//div[@id='upc-tv']");
	By installationGuideLink =By.xpath("//a//b[text()='How do I install My UPC TV Box ?']");
	
	public String getTitle() {
		return elementAction.waitForPageTitle(Constant.STEPPLAN_PAGE_TITLE);
	}
	
	public void clickOnTiles() {
		elementAction.doClick(technicalSupport);
		elementAction.doClick(tv);
		elementAction.doClick(upcTV);
	}
	
	public boolean isGuideLinkPresent() {
		System.out.println(elementAction.getElement(installationGuideLink).getText());
		return elementAction.isElementDisplayed(installationGuideLink);
	}
	
	
}
