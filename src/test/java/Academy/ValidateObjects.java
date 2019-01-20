package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateObjects extends Base {

	@Test
	public void validateTitle() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertEquals(landingPage.getFeaturedCoursesText().getText(), "FEATURED COURSES");
	}
	
	@Test
	public void validateMainNavigation() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getMainNavigationBar().isDisplayed());
	}
	
}
