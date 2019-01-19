package Academy;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password) throws IOException {
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLoginLink().click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailAddressInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
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
