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

public class SauceLabBasic {

	private WebDriver driver;
	static boolean result;

	@Test
	public void openBrowser() throws MalformedURLException {

		String sauceUserName = "Abhinav_Kumar19";
		String sauceAccessKey = "d7b1b7f2-21a1-46d6-a4ce-a1a93c0bb038";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", sauceUserName);
		capabilities.setCapability("accessKey", sauceAccessKey);

		capabilities.setCapability("browserName", "Safari");
		capabilities.setCapability("platform", "macOS 10.13");
		capabilities.setCapability("version", "11.1");

		capabilities.setCapability("name", "Check Test Run on Safari");

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