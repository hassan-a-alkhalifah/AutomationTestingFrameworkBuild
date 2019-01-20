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
	By featuredCoursesText = By.cssSelector("#content .container div:first-child h2");
	By mainNavigationBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	By popupCloseButton = By.cssSelector(".listbuilder-popup-content .sumome-react-wysiwyg-popup-animation-group .sumome-react-wysiwyg-popup-container.sumome-react-wysiwyg-popup.sumome-react-wysiwyg-is-resizing.sumome-animated-default div:nth-child(8)");
	
	public WebElement getLoginLink() {
		return driver.findElement(loginLink);
	}
	public WebElement getFeaturedCoursesText() {
		return driver.findElement(featuredCoursesText);
	}
	public WebElement getMainNavigationBar() {
		return driver.findElement(mainNavigationBar);
	}
	public WebElement getPopupCloseButton() {
		return driver.findElement(popupCloseButton);
	}
	
}
