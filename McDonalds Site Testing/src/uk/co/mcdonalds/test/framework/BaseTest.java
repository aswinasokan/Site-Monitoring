package uk.co.mcdonalds.test.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import uk.co.mcdonalds.section.Header;
import uk.co.mcdonalds.section.HomePage;
import uk.co.mcdonalds.section.SignUpOverlay;
import uk.co.mcdonalds.test.framework.driver.Chrome;

@Listeners({FailureListener.class})
public abstract class BaseTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		setUpDriver();
		
		launchSite();
		closeSignUpOverlay();
		closeCookieSection();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		closeDriver();
	}
	
	protected void setUpDriver() throws Exception {
		driver = new Chrome().getDriver();	//TODO: Externalise this Driver setup into Suites
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}	
	
	protected void closeDriver() throws Exception {
		driver.close();
		driver.quit();
	}		

	protected void launchSite() {
		navigateToHome();
		
		// Added to allow page to fully load, by Explicit Wait. Required only for IE synchronisation
		waitExplicit(ExpectedConditions.presenceOfElementLocated(SignUpOverlay.getSignUpSection())); 
		
		Assert.assertEquals(HomePage.TITLE, getTitle());
	}
	
	protected void closeSignUpOverlay() {
		if (isElementDisplayed(SignUpOverlay.getSignUpSection())) {
			getElement(SignUpOverlay.getCloseButton()).click();
			Assert.assertFalse(isElementDisplayed(SignUpOverlay.getSignUpSection()));
		}
	}
	
	protected void closeCookieSection() {
		if (isElementDisplayed(Header.getAcceptCookieSection())) {
			getElement(Header.getAcceptCookieLink()).click();
			Assert.assertFalse(isElementDisplayed(Header.getAcceptCookieSection()));
		}
	}	
	
	protected WebElement getElement(By by) {
		return driver.findElement(by);
	}
	
	protected List<WebElement> getElements(By by) {
		return driver.findElements(by);
	}

	@Deprecated  // Use isElementDisplayed() instead, to ensure visibility rather than presence/absence 
	protected boolean isElementPresent(By by) {
		try {
			getElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	protected boolean isElementDisplayed(By by) {
		try {
			return getElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	protected boolean isElementHidden(By by) {
		try {
			return !(getElement(by).isDisplayed());
		} catch (NoSuchElementException e) {
			return true;
		}
	}	
	
	protected void navigateTo(String url) {
		driver.get(url);
	}
	
	protected void navigateToHome() {
		navigateTo(HomePage.URL);
	}
	
	protected String getTitle() {
		return driver.getTitle();
	}
	
	protected String getUrl() {
		return driver.getCurrentUrl();
	}	
	
	protected <T> void waitExplicit(ExpectedCondition<T> conditions) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(conditions);
	}
}
