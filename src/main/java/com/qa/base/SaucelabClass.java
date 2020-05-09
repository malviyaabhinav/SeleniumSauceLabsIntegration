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

public class SaucelabClass {

	private WebDriver driver;
	static boolean result;

	@Test
	public void openBrowser() throws MalformedURLException {

		String sauceUserName = "Abhinav_Kumar19";
		String sauceAccessKey = "d7b1b7f2-21a1-46d6-a4ce-a1a93c0bb038";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", sauceUserName);
		capabilities.setCapability("accessKey", sauceAccessKey);

		/*
		 * capabilities.setCapability("browserName", "Safari");
		 * capabilities.setCapability("platform", "macOS 10.13");
		 * capabilities.setCapability("version", "11.1");
		 */

		// capabilities.setCapability("deviceName", "iPhone_6_carrier_test_sjc3");

		capabilities.setCapability("browserName", "iPad");
		// capabilities.setCapability("platform", "MAC");
		capabilities.setCapability("version", "latest");

		capabilities.setCapability("name", "Sixth Test Run on iPAD");

		driver = new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"), capabilities);
		driver.navigate().to("https://app.hubspot.com/login");
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		By email = By.id("username");
		By passwordfield = By.id("password");
		By loginButton = By.id("loginBtn");
		By signUp = By.linkText("Sign up");

		// wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));

		if (driver.findElement(signUp).getText().equalsIgnoreCase("signup")) {
			this.result = true;
		} else {
			this.result = false;
		}
		
		String id ="username";
		String value ="abhinavmalviya1992@gmail.com";
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");

		//driver.findElement(email).sendKeys("abhinavmalviya1992@gmail.com");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String id2 ="password";
		String value2 ="Selenium2020";
		js.executeScript("document.getElementById('" + id2 + "').value='" + value2 + "'");
		
		//driver.findElement(passwordfield).sendKeys("Selenium2020");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		js.executeScript("arguments[0].click();", driver.findElement(By.linkText("Sign up")));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		js.executeScript("arguments[0].click();", driver.findElement(By.id("loginBtn")));
		
		//driver.findElement(loginButton).click();
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