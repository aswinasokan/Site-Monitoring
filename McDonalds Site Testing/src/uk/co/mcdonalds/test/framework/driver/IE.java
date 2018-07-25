package uk.co.mcdonalds.test.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IE {

	public WebDriver getDriver() {
		String currentDir = System.getProperty("user.dir");
		String driverLocation = currentDir + "/tools/ie/IEDriverServer-64.exe";
		System.setProperty("webdriver.ie.driver", driverLocation);
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);		
		
		InternetExplorerOptions explorerOptions = new InternetExplorerOptions(capabilities);
		
		return new InternetExplorerDriver(explorerOptions);
	}
}
