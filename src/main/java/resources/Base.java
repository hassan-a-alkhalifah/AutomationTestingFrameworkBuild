package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver driver;
	public Properties props;
	
	public WebDriver initializeDriver() throws IOException {
		props = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\zzmar_000\\Desktop\\IT_Related\\AutomationTestingFrameworkBuild\\src\\main\\java\\resources\\data.properties");
		props.load(fis);
		String browserName = props.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String resultName) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\zzmar_000\\Desktop\\IT_Related\\AutomationTestingFrameworkBuild\\testScreenshots\\screenshot-" + resultName + ".png"));
	}
	
}
