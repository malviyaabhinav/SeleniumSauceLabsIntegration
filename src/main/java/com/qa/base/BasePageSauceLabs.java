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

public class BasePageSauceLabs {

	DesiredCapabilities capabilities;
	RemoteWebDriver driver;
	Properties property;

	/*
	 * Read property from SaucelabConfig.properties file
	 */
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
	 * This method reads properties from SaucelabConfig.properties file and
	 * initiates a browser on android device on Saucelabs Refer:
	 * https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/ for
	 * capabilities specification for combination of devices
	 */
	public RemoteWebDriver initiateRemoteDriverAndroid() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		String sauceUsername = property.getProperty("sauceUserName");
		String sauceAccessKey = property.getProperty("sauceAccessKey");
		capabilities.setCapability("username", sauceUsername);
		capabilities.setCapability("accessKey", sauceAccessKey);
		capabilities.setCapability("deviceName", property.getProperty("androidDeviceName"));
		capabilities.setCapability("deviceOrientation", property.getProperty("deviceOrientation"));
		capabilities.setCapability("browserName", property.getProperty("androidBrowserName"));
		capabilities.setCapability("platformVersion", property.getProperty("androidPlatformVersion"));
		capabilities.setCapability("platformName", property.getProperty("androidPlatformName"));
		capabilities.setCapability("name", property.getProperty("testCaseName"));
		driver = new RemoteWebDriver(new URL(property.getProperty("remoteGridURL")), capabilities);
		driver.navigate().to(property.getProperty("websiteURL"));
		return driver;
	}

	/*
	 * This method reads properties from SaucelabConfig.properties file and
	 * initiates a browser on desktop on Saucelabs Refer:
	 * https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/ for
	 * capabilities specification for combination of devices
	 */
	public RemoteWebDriver initiateRemoteDriverDesktop() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		String sauceUsername = property.getProperty("sauceUserName");
		String sauceAccessKey = property.getProperty("sauceAccessKey");
		capabilities.setCapability("username", sauceUsername);
		capabilities.setCapability("accessKey", sauceAccessKey);
		capabilities.setCapability("browserName", property.getProperty("desktopBrowserName"));
		capabilities.setCapability("platform", property.getProperty("desktopPlatform"));
		capabilities.setCapability("version", property.getProperty("desktopVersion"));
		capabilities.setCapability("name", property.getProperty("testCaseName"));
		driver = new RemoteWebDriver(new URL(property.getProperty("remoteGridURL")), capabilities);
		driver.navigate().to(property.getProperty("websiteURL"));
		return driver;
	}

	/*
	 * This method reads properties from SaucelabConfig.properties file and
	 * initiates a browser on iOS on Saucelabs Refer:
	 * https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/ for
	 * capabilities specification for combination of devices
	 */
	public RemoteWebDriver initiateRemoteDriveriOS() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		String sauceUsername = property.getProperty("sauceUserName");
		String sauceAccessKey = property.getProperty("sauceAccessKey");
		capabilities.setCapability("username", sauceUsername);
		capabilities.setCapability("accessKey", sauceAccessKey);
		capabilities.setCapability("deviceName", property.getProperty("iOSDeviceName"));
		capabilities.setCapability("deviceOrientation", property.getProperty("deviceOrientation"));
		capabilities.setCapability("platformVersion", property.getProperty("iOSPlatformVersion"));
		capabilities.setCapability("platformName", property.getProperty("iOSPlatformName"));
		capabilities.setCapability("browserName", property.getProperty("iOSBrowserName"));
		capabilities.setCapability("name", property.getProperty("testCaseName"));
		driver = new RemoteWebDriver(new URL(property.getProperty("remoteGridURL")), capabilities);
		driver.navigate().to(property.getProperty("websiteURL"));
		return driver;
	}

}
