package uk.co.mcdonalds.section;

import org.openqa.selenium.By;

public class CookieMessage {

	public static By getMessageSection() {
		return By.id("cookieMessage");
	}
	
	public static By getCloseButton() {
		return By.id("closeCookie");
	}
}
