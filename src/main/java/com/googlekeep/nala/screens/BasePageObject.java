package com.googlekeep.nala.screens;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class BasePageObject {
	protected AndroidDriver driver;
	protected Logger log;

	public BasePageObject(AndroidDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}

	protected WebElement find(By locator) {
		waitForVisibilityOf(locator, 5);
		return driver.findElement(locator);

	}

	protected void click(By locator) {
		waitForVisibilityOf(locator, 15);
		find(locator).click();

	}

	protected void waitForVisibilityOf(By locator, int timeO) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeO);
			} catch (StaleElementReferenceException e) {
				log.info("Could not Find element" + e);
				e.printStackTrace();
			}
			attempts++;
		}

	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
		timeout = timeout != null ? timeout : 20;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(condition);

	}

}