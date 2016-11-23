package uk.co.mcdonalds.section;

import org.openqa.selenium.By;

public class ProductPage {

	public final static String URL_BIG_MAC = HomePage.BASE_PATH + "product_nutrition.beef.19.big-mac.html";
	public final static String TITLE_BIG_MAC = "Big Mac® :: McDonalds.co.uk";
	
	public static By getNutritionDetailsLink() {
		return By.id("nutrition_toggle");
	}
	
	public static By getNutritionDetailsSection() {
		return By.id("food_content_segment");
	}
	
	public static By getNutritionDetailsProductNameSection() {
		return By.id("product_detail_name_nosize");
	}

	public static By getNutritionDetailsClosingSection() {
		return By.id("detail_bottom");
	}

	public static By getAddToCalculatorButton() {
		return By.cssSelector("a.acts_as_button.en_add_to_my_meal_red");
	}

	public static By getAddedMessageSection() {
		return By.id("added_confirmation");
	}
	
	public static By getViewCalculatorLink() {
		return By.linkText("View Nutrition Calculator");
	}	
}
