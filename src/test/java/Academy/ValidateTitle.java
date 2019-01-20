package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	
	@BeforeSuite
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
	}

	@Test
	public void validateTitle() {
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertEquals(landingPage.getFeaturedCoursesText().getText(), "FEATURED COURSES");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
}
