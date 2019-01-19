package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailAddressInput = By.id("user_email");
	By passwordInput = By.id("user_password");
	By loginButton = By.className("login-button");
	
	public WebElement getEmailAddressInput() {
		return driver.findElement(emailAddressInput);
	}
	public WebElement getPasswordInput() {
		return driver.findElement(passwordInput);
	}
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
}
