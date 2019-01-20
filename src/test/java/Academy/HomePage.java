package Academy;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	@BeforeMethod
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password) throws IOException {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLoginLink().click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailAddressInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
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
