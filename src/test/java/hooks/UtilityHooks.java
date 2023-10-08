package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

public class UtilityHooks {

	WebDriver driver;

	@Before
	public void setup() {
		Properties prop = ConfigReader.readConfigFile();
		driver = DriverFactory.initiliseBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void teardown(Scenario scenario) {

		String scenarioName = scenario.getName().replace(" ", "_");
		if (scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte[] bytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(bytes, "image/png", scenarioName);
		}
		driver.quit();

	}
}
