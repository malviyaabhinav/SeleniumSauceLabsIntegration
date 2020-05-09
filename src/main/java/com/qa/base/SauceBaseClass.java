package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceBaseClass {

	DesiredCapabilities capabilities;
	RemoteWebDriver driver;
	Properties property;

	public Properties readSaucelabProperty() {
		property = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					"D:\\OneDrive - Infosys Limited\\Eclipse_Workspace\\SeleniumSaucelabsIntegration\\src\\main\\java\\com\\qa\\prop\\SaucelabConfig.properties");
			property.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property;
	}

	/*
	 * This method reads properties from SaucelabConfig.properties file and initiates a browser on android device on Saucelabs
	 */
	public void initiateRemoteDriverAndroid() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		String sauceUsername = property.getProperty("sauceUserName");
		String sauceAccessKey = property.getProperty("sauceAccessKey");
		capabilities.setCapability("deviceName", property.getProperty("deviceName"));
		capabilities.setCapability("deviceOrientation", property.getProperty("deviceOrientation"));
		capabilities.setCapability("browserName", property.getProperty("browserName"));
		capabilities.setCapability("platformVersion", property.getProperty("platformVersion"));
		capabilities.setCapability("platformName", property.getProperty("platformName"));
		capabilities.setCapability("name", property.getProperty("testCaseName"));
		driver = new RemoteWebDriver(new URL(property.getProperty("remoteGridURL")), capabilities);
		driver.navigate().to(property.getProperty("websiteURL"));

	}

	/*
	 * This method reads properties from SaucelabConfig.properties file and initiates a browser on desktop on Saucelabs
	 */
	public void initiateRemoteDriverDesktop() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		String sauceUsername = property.getProperty("sauceUserName");
		String sauceAccessKey = property.getProperty("sauceAccessKey");
		capabilities.setCapability("browserName", "Safari");
		capabilities.setCapability("platform", "macOS 10.13");
		capabilities.setCapability("version", "11.1");
		capabilities.setCapability("name", property.getProperty("testCaseName"));
		driver = new RemoteWebDriver(new URL(property.getProperty("remoteGridURL")), capabilities);
		driver.navigate().to(property.getProperty("websiteURL"));

	}

	public void initiateRemoteDriveriOS() {

	}

}
