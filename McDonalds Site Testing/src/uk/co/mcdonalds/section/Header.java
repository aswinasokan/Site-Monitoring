package uk.co.mcdonalds.section;

import org.openqa.selenium.By;

public class Header {

	public static By getNutritionCalculatorLink() {
		return By.xpath("//div[@id='meal_builder']/a");
	}
	
	public static By getAcceptCookieSection() {
		return By.id("cookieMessage");
	}	
	
	public static By getAcceptCookieLink() {
		return By.id("closeCookie");
	}	
}
