package com.qa.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class SauceLabSupport {

	private WebDriver driver;
	static boolean result;

	@Test
	public void openBrowser() throws MalformedURLException {

		String sauceUserName = "Abhinav_Kumar19";
		String sauceAccessKey = "d7b1b7f2-21a1-46d6-a4ce-a1a93c0bb038";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", sauceUserName);
		capabilities.setCapability("accessKey", sauceAccessKey);
		
		  capabilities.setCapability(
		  "deviceName","Samsung Galaxy S8 Plus FHD GoogleAPI Emulator");
		  capabilities.setCapability("deviceOrientation", "portrait");
		  capabilities.setCapability("browserName", "Chrome");
		  capabilities.setCapability("platformVersion", "8.0");
		  capabilities.setCapability("platformName","Android");
		  capabilities.setCapability("name", "Validate Support Team Test Run on Android");
		 
		
		/*
		 * capabilities.setCapability("deviceName","iPhone 6s Simulator");
		 * capabilities.setCapability("deviceOrientation", "portrait");
		 * capabilities.setCapability("platformVersion","11.0");
		 * capabilities.setCapability("platformName", "iOS");
		 * capabilities.setCapability("browserName", "Safari");
		 * capabilities.setCapability("name", "Demo Test Run on iPhone 6S iOS 11.0");
		 */

		driver = new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"), capabilities);
		driver.navigate().to("https://app.hubspot.com/login");
		//driver.navigate().to("https://www-upc-ch.dev.aem.upc.biz/en/testing/corp/abhinav/stepplanpocpage/");
		try {
			Thread.sleep(45000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		By email = By.id("username");
		By passwordfield = By.id("password");
		By loginButton = By.id("loginBtn");
		By signUp = By.linkText("Sign up");

		if (driver.findElement(signUp).getText().equalsIgnoreCase("signup")) {
			this.result = true;
		} else {
			this.result = false;
		}

		driver.findElement(email).sendKeys("abhinavmalviya1992@gmail.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		driver.findElement(passwordfield).sendKeys("Selenium2020");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		driver.findElement(loginButton).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result) {
			((JavascriptExecutor) driver).executeScript("sauce:job-result=passed");
		} else {
			((JavascriptExecutor) driver).executeScript("sauce:job-result=failed");
		}
		driver.quit();

	}

}