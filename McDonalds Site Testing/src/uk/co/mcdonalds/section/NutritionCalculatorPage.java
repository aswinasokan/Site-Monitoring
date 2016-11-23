package uk.co.mcdonalds.section;

import org.openqa.selenium.By;

public class NutritionCalculatorPage {

	public final static String BASE_URL = HomePage.BASE_PATH + "meal_builder.html";
	public final static String TITLE = "Nutrition Calculator :: McDonalds.co.uk";
	
	public static By getEmptySection() {
		return By.id("empty_meal_builder");
	}
	
	public static By getSummarySection() {
		return By.id("meal_builder_calc");
	}
	
	public static By getProductListContents() {
		return By.xpath("//div[@id='calc_list']//div[*]");
	}
	
	public static By getRemoveItemConfirmButton() {
		return By.cssSelector("a.mcdColorboxConfirmYes");
	}

	public static By getRemoveItemCancelButton() {
		return By.cssSelector("a.mcdColorboxConfirmNo");
	}

	public static By getAddToCalculatorLink() {
		return By.id("form_submit");
	}
	
	public static By getEmptyCalculatorLink() {
		return By.id("empty_builder");
	}
	
	public static By getSelectedMenuItem() {
		return By.id("itemsDropdown");
	}
}
