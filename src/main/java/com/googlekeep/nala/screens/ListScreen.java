package com.googlekeep.nala.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class ListScreen extends BasePageObject {

	private By addTitleLocator = By.id("com.google.android.keep:id/editable_title");

	private By addListLocator = By.id("com.google.android.keep:id/add_item_text_view");

	private By listItemTextFieldLocator = By.id("com.google.android.keep:id/description");

	private By checkBoxLocator = By.xpath(
			"//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.CheckBox");

	private By unCheckBoxLocator = By.xpath(
			"//android.widget.LinearLayout[@index='4']/android.view.ViewGroup[@index='0']/android.widget.CheckBox");

	private By unCheckBoxLocator1 = By.xpath(
			"//android.widget.LinearLayout[@index='5']/android.view.ViewGroup[@index='0']/android.widget.CheckBox");

	private By confirmationScreenFieldLocator = By.id("com.google.android.keep:id/menu_switch_to_list_view");

	private By itemTobeDeletedLocator = By.xpath(
			"//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.EditText[@index='2']");

	private By deleteItemListLocator = By.xpath(
			"//android.widget.LinearLayout[@index='1']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='3']");

	private By backToHomePageLocator = By.className("android.widget.ImageButton");

	private By backToHomePageAfterEditLocator = By.id("com.google.android.keep:id/search_actionbar_back_button");

	private By threeButtonLocator = By.id("com.google.android.keep:id/bs_action_button");

	private By deleteButtonLocator = By.xpath("//*[contains(@text,'Delete')]");

	public ListScreen(AndroidDriver driver, Logger log) {
		super(driver, log);
	}

	public void createNewList() {
		log.info("Creating New List!!");

		log.info("Typing List title!!");

		type("Shopping List", addTitleLocator);

		click(addListLocator);

		type("Buy Bananas", listItemTextFieldLocator);

		driver.switchTo().activeElement().sendKeys("Buy Pineapples");

		click(addListLocator);

		driver.switchTo().activeElement().sendKeys("Buy Apples");

		click(addListLocator);

		driver.switchTo().activeElement().sendKeys("Buy Mangoes");

		log.info("List has been added successfully");

	}

	public void checkListItem() {
		log.info("Checking a List Item");
		type("Shopping List", addTitleLocator);
		log.info("Checking List Item!!");

		click(backToHomePageLocator);

		click(checkBoxLocator);

		click(checkBoxLocator);

	}

	public void deleteListItem() {
		log.info("Deleting List Items");

		click(itemTobeDeletedLocator);

		click(deleteItemListLocator);
	}

	public void deleteCompleteList() {
		log.info("Deleting List");

		click(threeButtonLocator);

		click(deleteButtonLocator);
	}

	public void unCheckListItem() {

		log.info("Unchecking List Items!!");

		click(unCheckBoxLocator);

		click(unCheckBoxLocator1);
	}

	public boolean isSConfirmButtonVisible() {
		return find(confirmationScreenFieldLocator).isDisplayed();
	}

	public HomeScreen returnToHomeScreen() {

		click(backToHomePageLocator);

		log.info("Back To home Screen after List Action");

		return new HomeScreen(driver, log);

	}
	
	public HomeScreen returnToHomeScreenAfterDelete() {

		click(backToHomePageAfterEditLocator);

		log.info("Back To home Screen after List Action");

		return new HomeScreen(driver, log);

	}

	public HomeScreen returnToHomeScreenAfterListEdit() {

		click(backToHomePageLocator);

		click(backToHomePageAfterEditLocator);

		log.info("Back To home Screen after List Edit");
		return new HomeScreen(driver, log);

	}

}
