package com.googlekeep.nala.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.googlekeep.nala.base.TestUtilities;
import com.googlekeep.nala.screens.HomeScreen;
import com.googlekeep.nala.screens.NotesScreen;
import com.googlekeep.nala.screens.WelcomeScreen;

public class NotesTests extends TestUtilities {

	@Test(priority = 1)
	public void addNote() {
		log.info("Starting Addition of Notes");

		WelcomeScreen welcomeScreen = new WelcomeScreen(driver, log);

		HomeScreen homeScreen = welcomeScreen.moveToHomeScreen();

		NotesScreen addNoteScreen = homeScreen.moveToNoteScreen();

		addNoteScreen.createNote();

		addNoteScreen.navigateToHomePage();

	}

	@Test(priority = 2)
	public void searchNote() {

		HomeScreen homeScreen = new HomeScreen(driver, log);
		homeScreen.searchText();

	}

	@Test(priority = 3)
	public void deleteNote() {

		NotesScreen noteScreen = new NotesScreen(driver, log);
		noteScreen.deleteNote();
	
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(
				noteScreen.actualEmptySearchMessage().contains(noteScreen.expectedEmptySearchMessage),
				noteScreen.actualEmptySearchMessage() + noteScreen.expectedEmptySearchMessage);

		noteScreen.goBackToHomeScreen();

	}

}
