package com.googlekeep.nala.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class HomeScreen extends BasePageObject {

	private By searchBarLocator = By.id("com.google.android.keep:id/toolbar");
	
	private By queryTextLocator = By.id("com.google.android.keep:id/search_actionbar_query_text");

	private By addNoteLocator = By.id("com.google.android.keep:id/new_note_button");

	private By listButtonLocator = By.id("com.google.android.keep:id/new_list_button");

	
	private By searchResultLocator = By.id("com.google.android.keep:id/background_theme_image_view");
	
	public HomeScreen(AndroidDriver driver, Logger log) {
		super(driver, log);

	}

	public NotesScreen moveToNoteScreen() {

		click(addNoteLocator);

		return new NotesScreen(driver, log);
	}
	
	public ListScreen moveToListScreen() {

		click(listButtonLocator);

		return new ListScreen(driver, log);
	}

	public NotesScreen searchText() {

		click(searchBarLocator);
		
		log.info("Searching Text");

		type("Testing", queryTextLocator);
		
		click(searchResultLocator);
		
		return new NotesScreen(driver, log);

	}

	public ListScreen searchList() {

		click(searchBarLocator);
		
		log.info("Searching List");

		type("Shopping List", queryTextLocator);
		
		click(searchResultLocator);
		
		return new ListScreen(driver, log);

	}
	public ListScreen clickSearchedList() {
		
		click(searchResultLocator);
		
		return new ListScreen(driver, log);

	}
	
}
