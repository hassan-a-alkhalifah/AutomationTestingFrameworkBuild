package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By loginLink = By.cssSelector(".pull-right ul li:nth-child(4) a");
	
	public WebElement getLoginLink() {
		return driver.findElement(loginLink);
	}
	
}
