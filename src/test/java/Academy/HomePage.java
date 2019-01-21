package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(props.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password) throws IOException {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLoginLink().click();
		log.info("Successfully clicked login link");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailAddressInput().sendKeys(email);
		log.info("Successfully entered email into email input");
		loginPage.getPasswordInput().sendKeys(password);
		log.info("Successfully entered password into password input");
		loginPage.getLoginButton().click();
		log.info("Successfully clicked login button");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("Successfully shutdown driver and closed browser");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "1234";
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "5678";
		return data;
	}
	
}
