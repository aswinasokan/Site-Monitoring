package uk.co.mcdonalds.section;

import org.openqa.selenium.By;

public class FootballMotyForm {

	public final static String URL = Football.BASE_PATH + "LetsPlay/community-awards.html";
	public final static String TITLE = "Community Awards :: McDonalds.co.uk";
	
	public static By getNominateButton() {
		return By.cssSelector("a.nominate.nominate-form");
	}
	
	public static By getOverlay() {
		return By.xpath("//html/body/div[@class='modal-popup']");
	}
	
	public static By getOverlayCloseButton() {
		return By.xpath("//html/body/div[@class='modal-popup']/div[@class='modal-content']/button[@class='btn-close']");
	}	

}
