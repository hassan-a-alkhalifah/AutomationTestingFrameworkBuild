package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateMainNavigationBar extends Base {

	@BeforeSuite
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
	}
	
	@Test
	public void validateMainNavigation() {
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getMainNavigationBar().isDisplayed());
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
}
