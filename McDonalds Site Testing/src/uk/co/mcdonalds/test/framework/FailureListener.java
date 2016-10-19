package uk.co.mcdonalds.test.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class FailureListener extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult result) {
		
		// Create a screenshot of failed screen
		WebDriver driver = ((BaseTest)result.getInstance()).driver;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Place image into test output folder
		String timeStamp = new SimpleDateFormat("_yyyyMMdd_HHmmss_").format(new Date());
		String outputFolder = result.getTestContext().getOutputDirectory();
		String imageFileName = "failshot" + timeStamp + result.getTestClass().getRealClass().getSimpleName() + "." + result.getName() + "().png";
		
		try {
			FileUtils.copyFile(scrFile, new File(outputFolder + "\\" + imageFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
