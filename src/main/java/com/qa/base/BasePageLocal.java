package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePageLocal {

	WebDriver driver;
	Properties property;

	/*
	 * This method is used to read property from config file.
	 */
	public Properties getProperty() {
		property = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					"D:\\OneDrive - Infosys Limited\\Eclipse_Workspace\\SeleniumSaucelabsIntegration\\src\\main\\java\\com\\qa\\prop\\config.properties");
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
	 * This method is used to initiate driver locally
	 */
	
	public WebDriver initiateDriverLocal() {
		String browser =property.getProperty("browser");
		String url =property.getProperty("url");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		}
		else {
			System.out.println("Please select one of the browser from: chrome, firefox, edge");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	
	
	public void initializeSaucelabBrowser() {
		
		
		
	}
	
	
	
	
	
	
}

















