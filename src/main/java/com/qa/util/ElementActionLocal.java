package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActionLocal {
	WebDriver driver;
	Actions action;

	public ElementActionLocal(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementPresence(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement getElement(By locator) {
		waitForElementPresence(locator);
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some exception occured while fetching the element: " + e.getMessage());
		}
		return element;
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
			;
		} catch (Exception e) {
			System.out.println("Some error occurred while clicking the element: " + e.getMessage());
		}
	}

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some error occurred while inserting the text: " + e.getMessage());
		}
	}

	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Some error occured while getting the text: " + e.getMessage());
		}
		return text;
	}

	public String waitForPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Some error occurred while searching the element: " + e.getMessage());
			return false;
		}
	}

	public void moveToElement(By locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}

}
