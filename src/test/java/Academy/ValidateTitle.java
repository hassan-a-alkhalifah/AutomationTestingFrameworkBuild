package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(props.getProperty("url"));
	}

	@Test
	public void validateTitle() {
		LandingPage landingPage = new LandingPage(driver);
		Assert.assertEquals(landingPage.getFeaturedCoursesText().getText(), "FEATURED COURSES");
		log.info("Successfully identified FEATURED COURSES text");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Successfully shutdown driver and closed browser");
	}
	
}
