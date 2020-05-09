package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.base.BasePageSauceLabs;
import com.qa.util.Constant;
import com.qa.util.ElementActionRemote;

public class HubSpotLoginPage extends BasePageSauceLabs{
	
	RemoteWebDriver driver;
	ElementActionRemote elementAction;
	
	public HubSpotLoginPage(RemoteWebDriver driver) {
		this.driver =driver;
		elementAction = new ElementActionRemote(this.driver);
	}
	
	By email = By.id("username");
	By passwordfield = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	By showPassword = By.xpath("//span[contains(text(),'Show Password')]");
	By forgotPassword = By.linkText("Forgot my password");
	
	
	public String getTitle() {
		return elementAction.waitForPageTitle(Constant.HUBSPOT_LOGIN_PAGE_TITLE);
	}
	
	public void doLogin(String username, String password) {
		elementAction.doSendKeys(email, username);
		elementAction.doSendKeys(passwordfield, password);
		elementAction.doClick(loginButton);	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void forgotPassword() {
		elementAction.doClick(forgotPassword);
	}

	public void showPassword() {
		elementAction.doClick(showPassword);
	}

	public boolean signUpDisplayed() {
		return elementAction.isElementDisplayed(signUp);
	}

	public void signUp() {
		elementAction.doClick(signUp);
	}
	

}
