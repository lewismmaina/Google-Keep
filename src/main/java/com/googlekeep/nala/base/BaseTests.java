package com.googlekeep.nala.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTests {
	protected AndroidDriver driver;;
	protected Logger log;

	@BeforeClass(alwaysRun = true)
	public void setUp(ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung SM-M115F");
		caps.setCapability(MobileCapabilityType.UDID, "R9JN70AWBDJ");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");

		URL url;
		try {
			url = new URL("http://localhost:4723/wd/hub");

			driver = new AndroidDriver(url, caps);

		} catch (MalformedURLException e) {
			String error = e.getMessage();
			log.info(error);

			e.printStackTrace();
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
