package uk.co.mcdonalds.test.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IE {

	public WebDriver getDriver() {
		String currentDir = System.getProperty("user.dir");
		String driverLocation = currentDir + "/tools/ie/IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", driverLocation);
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);		
		
		return new InternetExplorerDriver(capabilities);
	}
}
