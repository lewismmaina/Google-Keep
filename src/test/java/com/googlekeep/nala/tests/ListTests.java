package com.googlekeep.nala.tests;

import org.testng.annotations.Test;

import com.googlekeep.nala.base.TestUtilities;
import com.googlekeep.nala.screens.HomeScreen;
import com.googlekeep.nala.screens.ListScreen;
import com.googlekeep.nala.screens.WelcomeScreen;

public class ListTests extends TestUtilities {

	@Test(priority = 1)
	public void addNewList() {
		//Method to create a new List
		
		log.info("Starting Addition of a New List");

		WelcomeScreen welcomeScreen = new WelcomeScreen(driver, log);

		HomeScreen homeScreen = welcomeScreen.moveToHomeScreen();

		ListScreen addListScreen = homeScreen.moveToListScreen();

		addListScreen.createNewList();

		addListScreen.returnToHomeScreen();

	}

	@Test(priority = 2)
	public void searchList() {
		//Method to search a list

		HomeScreen homeScreen = new HomeScreen(driver, log);
		homeScreen.searchList();

	}

	@Test(priority = 3)
	public void checkAnItemInTheList() {

		ListScreen listScreen = new ListScreen(driver, log);
		listScreen.checkListItem();

		listScreen.returnToHomeScreen();

	}

	@Test(priority = 4)
	public void deleteItemsInTheList() {

		HomeScreen homeScreen = new HomeScreen(driver, log);

		ListScreen listScreen = homeScreen.clickSearchedList();

		listScreen.deleteListItem();

		listScreen.returnToHomeScreen();

	}

	@Test(priority = 5)
	public void unCheckItemsInTheList() {

		HomeScreen homeScreen = new HomeScreen(driver, log);
		ListScreen listScreen = homeScreen.clickSearchedList();

		listScreen.unCheckListItem();

		listScreen.returnToHomeScreen();

	}
	
	@Test(priority = 6)
	public void deleteList() {

		HomeScreen homeScreen = new HomeScreen(driver, log);
		ListScreen listScreen = homeScreen.clickSearchedList();

		listScreen.deleteCompleteList();

		listScreen.returnToHomeScreenAfterDelete();

	}

}
