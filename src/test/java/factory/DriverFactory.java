package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.CommonUtils;

public class DriverFactory {

	static WebDriver driver=null;
	public static WebDriver initiliseBrowser(String browsername) {
		
		switch (browsername) {
		case "chrome":
			ChromeDriverService service=new ChromeDriverService.Builder().usingAnyFreePort().withLogOutput(System.out).build();
			//System.setProperty("webdriver.chrome.driver", "F:\\imp\\selenium Tutorial\\chromedriver.exe");
			driver=new ChromeDriver(service);
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			driver=new ChromeDriver();
			break;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIMEOUT));
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
