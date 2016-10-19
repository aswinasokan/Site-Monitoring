package uk.co.mcdonalds.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.mcdonalds.section.CookieMessage;
import uk.co.mcdonalds.section.HomePage;
import uk.co.mcdonalds.section.NewsletterSignUpPage;
import uk.co.mcdonalds.section.SignUpOverlay;
import uk.co.mcdonalds.test.framework.BaseTest;

public class Home extends BaseTest {

	@BeforeMethod
	public void setUp() throws Exception {
		setUpDriver();
		launchSite();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		closeDriver();
	}
	
	@Test
	public void signupFromOverlay() {
		// Click on SignUp button on overlay. 
		// Check if navigates to Newsletter SignUp page
		// Check if Cookie message is displayed
		getElement(SignUpOverlay.getSignUpButton()).click();
		Assert.assertEquals(NewsletterSignUpPage.TITLE, getTitle());
		Assert.assertTrue(isElementDisplayed(CookieMessage.getMessageSection()));
	}
	
	@Test
	public void closeCookieMessage() {
		// Click on Close button on overlay
		// Check if still on Home page
		getElement(SignUpOverlay.getCloseButton()).click();
		Assert.assertEquals(HomePage.TITLE, getTitle());
		
		// Check if Cookie message is displayed
		// Click on Cookie message close button
		// Check if Cookie message is hidden
		Assert.assertTrue(isElementDisplayed(CookieMessage.getMessageSection()));
		getElement(CookieMessage.getCloseButton()).click();
		Assert.assertTrue(isElementHidden(CookieMessage.getMessageSection()));
	}
}
