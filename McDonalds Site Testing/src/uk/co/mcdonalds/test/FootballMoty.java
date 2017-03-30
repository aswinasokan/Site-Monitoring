package uk.co.mcdonalds.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import uk.co.mcdonalds.section.FootballMotyForm;
import uk.co.mcdonalds.test.framework.BaseTest;

public class FootballMoty extends BaseTest {

	@BeforeClass
	public void setUp() throws Exception {
		setUpDriver();
	}

	@Test
	public void verifySubmit() {
		navigateTo("http://www1.development.mcdonalds.com/ukfootballforms/MOTY.do");
		
		click(FootballMotyForm.getAgeCheckRadio());
		
	    selectValue(FootballMotyForm.getTitleSelect(), "Mr");
	    enterText(FootballMotyForm.getFirstNameText(), "Test");
	    enterText(FootballMotyForm.getLastNameText(), "Test");
	    enterText(FootballMotyForm.getPhoneNumberText(), "07827950123");
	    enterText(FootballMotyForm.getEmailText(), "Test@Test.com");
	    enterText(FootballMotyForm.getPostcodeText(), "N12 9XB");
	    enterText(FootballMotyForm.getDobDateText(), "01");
	    enterText(FootballMotyForm.getDobMonthText(), "01");
	    enterText(FootballMotyForm.getDobYearText(), "1978");

	    selectValue(FootballMotyForm.getNomineeTitleSelect(), "Mr");
	    enterText(FootballMotyForm.getNomineeFirstNameText(), "Test");
	    enterText(FootballMotyForm.getNomineeLastNameText(), "Test");
	    enterText(FootballMotyForm.getNomineePhoneNumberText(), "07827950123");
	    enterText(FootballMotyForm.getNomineeEmailText(), "Test@Test.com");
	    enterText(FootballMotyForm.getNomineeTownText(), "Town");
	    selectValue(FootballMotyForm.getNomineeCountrySelect(), "England");
	    enterText(FootballMotyForm.getClubNameText(), "Club Name");
	    enterText(FootballMotyForm.getRoleInClubText(), "Role in Club");	    
	    enterText(FootballMotyForm.getNominationText(), "Test description for nominaton of nominee");
	    
	    click(FootballMotyForm.getOptInBetterPlayRadio());
	    click(FootballMotyForm.getOptInGeneriRadio());
	    click(FootballMotyForm.getOptInTermsRadio());
	    
	    click(FootballMotyForm.getSubmitButton());
	    
		// Check Thank you page
	    Assert.assertEquals(FootballMotyForm.URL_THANKYOU, getUrl());
	}	
	
/*	@Test
	public void verifySubmit() {
		navigateTo(FootballMotyForm.URL);
		
		// Check page title
		Assert.assertEquals(FootballMotyForm.TITLE, getTitle());
		
		// Open
		Assert.assertTrue(isElementDisplayed(FootballMotyForm.getNominateButton()));
		getElement(FootballMotyForm.getNominateButton()).click();
		Assert.assertTrue(isElementDisplayed(FootballMotyForm.getOverlay()));
		
		// Fill data fields
		switchFrame(FootballMotyForm.getFormFrame());
		
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(FootballMotyForm.getAgeCheckRadio()));
		click(FootballMotyForm.getAgeCheckRadio());
		
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(FootballMotyForm.getTitleSelect()));
		
	    selectValue(FootballMotyForm.getTitleSelect(), "Mr");
	    enterText(FootballMotyForm.getFirstNameText(), "Test");
	    enterText(FootballMotyForm.getLastNameText(), "Test");
	    enterText(FootballMotyForm.getPhoneNumberText(), "07666999123");
	    enterText(FootballMotyForm.getEmailText(), "Test@Test.com");
	    enterText(FootballMotyForm.getPostcodeText(), "N12 9XB");
	    enterText(FootballMotyForm.getDobDateText(), "01");
	    enterText(FootballMotyForm.getDobMonthText(), "01");
	    enterText(FootballMotyForm.getDobYearText(), "1978");

		// Check Thank you page
	}*/	
	
/*	@BeforeMethod
	public void setUp() throws Exception {
		setUpDriver();
		
		navigate(FootballMotyForm.URL);

		// Added to allow page to fully load, by Explicit Wait. Required only for IE synchronisation
		waitExplicit(ExpectedConditions.presenceOfElementLocated(SignUpOverlay.getSignUpSection())); 
		
		closeSignUpOverlay();
		closeCookieSection();
	}*/	
	
/*	@Test
	public void verifyDesktopPopUp() {
		navigateTo(FootballMotyForm.URL);
		
		// Check page title
		Assert.assertEquals(FootballMotyForm.TITLE, getTitle());
		
		// Open
		Assert.assertTrue(isElementDisplayed(FootballMotyForm.getNominateButton()));
		getElement(FootballMotyForm.getNominateButton()).click();
		Assert.assertTrue(isElementDisplayed(FootballMotyForm.getOverlay()));

		// Close
		Assert.assertTrue(isElementDisplayed(FootballMotyForm.getOverlayCloseButton()));
		getElement(FootballMotyForm.getOverlayCloseButton()).click();
		Assert.assertTrue(isElementAbsent(FootballMotyForm.getOverlay()));
		Assert.assertTrue(isElementAbsent(FootballMotyForm.getOverlayCloseButton()));
	}*/

}
