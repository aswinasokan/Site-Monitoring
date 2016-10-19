package uk.co.mcdonalds.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import uk.co.mcdonalds.section.Header;
import uk.co.mcdonalds.section.NutritionCalculatorPage;
import uk.co.mcdonalds.section.ProductPage;
import uk.co.mcdonalds.test.framework.BaseTest;

public class Nutrition extends BaseTest {
	
	@AfterMethod
	private void clearTestData() {
		// Clear items from if present in Nutrition calculator
		navigateTo(NutritionCalculatorPage.BASE_URL);
		if (isElementDisplayed(NutritionCalculatorPage.getSummarySection())) {
			getElement(NutritionCalculatorPage.getEmptyCalculatorLink()).click();
			waitExplicit(ExpectedConditions.visibilityOfElementLocated(NutritionCalculatorPage.getRemoveItemConfirmButton()));
			getElement(NutritionCalculatorPage.getRemoveItemConfirmButton()).click();
			Assert.assertTrue(isElementDisplayed(NutritionCalculatorPage.getEmptySection()));
		}
	}
	
	@Test
	public void verifyProductPageNutritionExpandCollapse() {
		navigateTo(ProductPage.URL_BIG_MAC);
		
		// Expand
		getElement(ProductPage.getNutritionDetailsLink()).click();
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(ProductPage.getNutritionDetailsSection()));
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(ProductPage.getNutritionDetailsProductNameSection()));
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(ProductPage.getNutritionDetailsClosingSection()));
		
		//Collapse
		getElement(ProductPage.getNutritionDetailsLink()).click();
		waitExplicit(ExpectedConditions.invisibilityOfElementLocated(ProductPage.getNutritionDetailsSection()));
		waitExplicit(ExpectedConditions.invisibilityOfElementLocated(ProductPage.getNutritionDetailsProductNameSection()));
		waitExplicit(ExpectedConditions.invisibilityOfElementLocated(ProductPage.getNutritionDetailsClosingSection()));
		
	}

	@Test
	public void addToNutritionCalculatorFromProductPage() {
		// Navigate to product page
		// Ensure View NC link is hidden
		navigateTo(ProductPage.URL_BIG_MAC);
		Assert.assertTrue(isElementHidden(ProductPage.getViewCalculatorLink()));
		
		// Add Product to Nutrition Calculator
		// Wait for "Successfully Added" message to be displayed
		getElement(ProductPage.getAddToCalculatorButton()).click();
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(ProductPage.getAddedMessageSection()));

		// Check if View NC link is displayed
		Assert.assertTrue(isElementDisplayed(ProductPage.getViewCalculatorLink()));
				
		// Check if page header NC link is updated with item count
		String headerLink = getElement(Header.getNutritionCalculatorLink()).getText();
		Assert.assertTrue(headerLink.contains("1 items"));

		// Navigate to NC page through View NC link on Product page
		// Check if navigated to NC page
		getElement(ProductPage.getViewCalculatorLink()).click();
		Assert.assertEquals(NutritionCalculatorPage.TITLE, getTitle());
		
		// Check if NC is not empty
		Assert.assertTrue(isElementHidden(NutritionCalculatorPage.getEmptySection()));
		// Check if NC summary is displayed
		Assert.assertTrue(isElementDisplayed(NutritionCalculatorPage.getSummarySection()));
		// Check if product list is displayed
		Assert.assertTrue(getElements(NutritionCalculatorPage.getProductListContents()).size() > 0);
	}
	
	@Test
	public void addToNutritionCalculatorFromWithin() {
		// Add Product from within the Nutrition Calculator page
		navigateTo(NutritionCalculatorPage.BASE_URL);
		waitExplicit(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(NutritionCalculatorPage.getSelectedMenuItem()).getText().length() != 0;
			}
		});
		
		Assert.assertTrue(isElementDisplayed(NutritionCalculatorPage.getEmptySection()));
		
		getElement(NutritionCalculatorPage.getAddToCalculatorLink()).click();
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(NutritionCalculatorPage.getSummarySection()));
		
		Assert.assertTrue(isElementHidden(NutritionCalculatorPage.getEmptySection()));
		// Check if product list is displayed
		Assert.assertTrue(getElements(NutritionCalculatorPage.getProductListContents()).size() > 0);
	}	
	
	@Test
	public void verifyEmptyNutritionCalculator() {
		// Check NC when no products are added
		navigateTo(NutritionCalculatorPage.BASE_URL);

		Assert.assertTrue(isElementDisplayed(NutritionCalculatorPage.getEmptySection()));
		Assert.assertTrue(isElementHidden(NutritionCalculatorPage.getSummarySection()));
		Assert.assertTrue(getElements(NutritionCalculatorPage.getProductListContents()).size() == 0);
	}

	@Test
	public void addAndEmptyWithinNutritionCalculator() {
		// Add from Nutrition Calculator page, remove and check for empty
		navigateTo(NutritionCalculatorPage.BASE_URL);
		waitExplicit(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(NutritionCalculatorPage.getSelectedMenuItem()).getText().length() != 0;
			}
		});
		
		getElement(NutritionCalculatorPage.getAddToCalculatorLink()).click();
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(NutritionCalculatorPage.getSummarySection()));
		
		getElement(NutritionCalculatorPage.getEmptyCalculatorLink()).click();
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(NutritionCalculatorPage.getRemoveItemConfirmButton()));
		getElement(NutritionCalculatorPage.getRemoveItemConfirmButton()).click();
		
		Assert.assertTrue(isElementDisplayed(NutritionCalculatorPage.getEmptySection()));
		Assert.assertTrue(isElementHidden(NutritionCalculatorPage.getSummarySection()));
		Assert.assertTrue(getElements(NutritionCalculatorPage.getProductListContents()).size() == 0);
	}
	
	@Test
	public void addFromProductPageAndEmptyNutritionCalculator() {
		// Add from Product page, remove from within Nutrition Calculator page and check for empty
		navigateTo(ProductPage.URL_BIG_MAC);
		
		// Add to Nutrition Calculator
		getElement(ProductPage.getAddToCalculatorButton()).click();
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(ProductPage.getAddedMessageSection()));

		navigateTo(NutritionCalculatorPage.BASE_URL);
		getElement(NutritionCalculatorPage.getEmptyCalculatorLink()).click();
		waitExplicit(ExpectedConditions.visibilityOfElementLocated(NutritionCalculatorPage.getRemoveItemConfirmButton()));
		getElement(NutritionCalculatorPage.getRemoveItemConfirmButton()).click();
		Assert.assertTrue(isElementDisplayed(NutritionCalculatorPage.getEmptySection()));
	}
}
