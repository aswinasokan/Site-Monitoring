package uk.co.mcdonalds.test.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	public WebDriver getDriver() {
		String currentDir = System.getProperty("user.dir");
		String driverLocation = currentDir + "/tools/marionette/wires.exe";
		System.setProperty("webdriver.gecko.driver", driverLocation);
		
		return new FirefoxDriver();
	}
}
