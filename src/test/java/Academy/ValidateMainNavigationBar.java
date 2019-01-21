package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateMainNavigationBar extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeSuite
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(props.getProperty("url"));
	}
	
	@Test
	public void validateMainNavigation() {
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getMainNavigationBar().isDisplayed());
		log.info("Successfully identified main navigation");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
		log.info("Successfully shutdown driver and closed browser");
	}
	
}
