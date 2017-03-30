package uk.co.mcdonalds.section;

import org.openqa.selenium.By;

public class FootballMotyForm {

	public final static String URL = Football.BASE_PATH + "LetsPlay/community-awards.html";
	public final static String TITLE = "Community Awards :: McDonalds.co.uk";
	
	public final static String URL_THANKYOU = "http://www.mcdonalds.co.uk/ukhome/Sport/Football/LetsPlay/MOTY-awards/thankyou.html";
	
	public static By getNominateButton() {
		return By.linkText("Apply to host an event");
	}
	
	public static By getOverlay() {
		return By.xpath("/html/body/div[@class='modal-popup']");
	}
	
	public static By getOverlayCloseButton() {
		return By.xpath("/html/body/div[@class='modal-popup']/div[@class='modal-content']/button[@class='btn-close']");
	}
	
	public static By getFormFrame() {
		return By.xpath("/html/body/div[@class='modal-popup']/div[@class='modal-content']/iframe");
	}
	
	public static By getAgeCheckRadio() {
		return By.id("overAge");
	}
	
	public static By getTitleSelect() {
		return By.id("title");
	}
	
	public static By getFirstNameText() {
		return By.id("firstName");
	}
	
	public static By getLastNameText() {
		return By.id("lastName");
	}
	
	public static By getPhoneNumberText() {
		return By.id("phoneNumber");
	}
	
	public static By getEmailText() {
		return By.id("email");
	}
	
	public static By getPostcodeText() {
		return By.id("postcode");
	}
	
	public static By getDobDateText() {
		return By.id("birthDay");
	}	
	
	public static By getDobMonthText() {
		return By.id("birthMonth");
	}
	
	public static By getDobYearText() {
		return By.id("birthYear");
	}
	
	public static By getNomineeTitleSelect() {
		return By.name("nominee.title");
	}
	
	public static By getNomineeFirstNameText() {
		return By.id("nom_firstName");
	}
	
	public static By getNomineeLastNameText() {
		return By.id("nom_lastName");
	}
	
	public static By getNomineePhoneNumberText() {
		return By.id("nom_phoneNumber");
	}
	
	public static By getNomineeEmailText() {
		return By.id("nom_email");
	}
	
	public static By getNomineeTownText() {
		return By.id("nom_town");
	}
	
	public static By getNomineeCountrySelect() {
		return By.id("nom_clubCountry");
	}
	
	public static By getClubNameText() {
		return By.id("nom_clubname");
	}
	
	public static By getRoleInClubText() {
		return By.id("nom_role");
	}

	public static By getNominationText() {
		return By.id("nom_description");
	}

	public static By getOptInBetterPlayRadio() {
		return By.id("optBetterPlayNo");
	}
	
	public static By getOptInGeneriRadio() {
		return By.id("optGenericNo");
	}
	
	public static By getOptInTermsRadio() {
		return By.id("optTermsYes");
	}
	
	public static By getSubmitButton() {
		return By.id("submitBtn");
	}
}
