package com.googlekeep.nala.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class NotesScreen extends BasePageObject{
	 
	 private By addTitleLocator = By.id("com.google.android.keep:id/editable_title");
	 
	 private By addNoteLocator = By.id("com.google.android.keep:id/edit_note_text");
	 
	 private By backNaviLocator = By.className("android.widget.ImageButton");
	 
	 private By threeButtonLocator = By.id("com.google.android.keep:id/bs_action_button");
	 
	 private By deleteButtonLocator = By.xpath("//*[contains(@text,'Delete')]");
	 
	 public String expectedEmptySearchMessage = "No matching notes";
	 
	
	 
	 private By backAfterSearchLocator = By.id("com.google.android.keep:id/search_actionbar_back_button");
	
	 private By expectedTextAfterDeleteLocator = By.id("com.google.android.keep:id/empty_view_text");

	public NotesScreen(AndroidDriver driver, Logger log) {
		super(driver, log);
		
	}
	
	public void createNote() {
		log.info("Typing title!!");
		type("Testing Title",addTitleLocator);
		log.info("Typing Note!!");
		type("Testing Note",addNoteLocator);
		
	}
	
	
	public HomeScreen navigateToHomePage(){
		click(backNaviLocator);
		
		return new HomeScreen(driver, log);
		
		
	}
	
	public void deleteNote() {
		click(threeButtonLocator);
		
		click(deleteButtonLocator);
		
	
	}
	
	public HomeScreen goBackToHomeScreen() {

		click(backAfterSearchLocator);
		
		return new HomeScreen(driver, log);
		
	}
	
	public String actualEmptySearchMessage() {
		return find(expectedTextAfterDeleteLocator).getText();
		
		
	}
}
