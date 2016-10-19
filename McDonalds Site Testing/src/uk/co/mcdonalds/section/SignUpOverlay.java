package uk.co.mcdonalds.section;

import org.openqa.selenium.By;

public class SignUpOverlay {

	public static By getSignUpSection() {
		return By.id("signupModal");
	}
	
	public static By getCloseButton() {
		return By.id("closeSignup");
	}
	
	public static By getSignUpButton() {
		return By.id("signup");
	}	
}
