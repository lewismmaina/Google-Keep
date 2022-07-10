package com.googlekeep.nala.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class WelcomeScreen  extends BasePageObject{
	private By skipWelcomeLocator = By.id("com.google.android.keep:id/skip_welcome");

	public WelcomeScreen(AndroidDriver driver, Logger log) {
		super(driver, log);

	}

	
	public boolean isSkipWelcomeButtonVisible() {
		return find(skipWelcomeLocator).isDisplayed();
	}
	
	public HomeScreen moveToHomeScreen() {
		if(isSkipWelcomeButtonVisible()==true) {
			log.info("Found Skip Welcome Locator");
			
			click(skipWelcomeLocator);			
			return new HomeScreen(driver, log);
			
		}
	
		return new HomeScreen(driver, log);
	}
	

}
