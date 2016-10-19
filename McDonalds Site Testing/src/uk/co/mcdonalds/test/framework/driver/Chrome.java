package uk.co.mcdonalds.test.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {

	public WebDriver getDriver() {
		String currentDir = System.getProperty("user.dir");
		String driverLocation = currentDir + "\\tools\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverLocation);
		
		return new ChromeDriver();
	}
}
