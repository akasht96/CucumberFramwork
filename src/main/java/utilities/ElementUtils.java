package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitForElement(WebElement element, long duration) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return webElement;
	}

	public void typetextIntoElement(WebElement element, String textToBeEntered, long duration) {
		WebElement webElement = waitForElement(element, duration);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeEntered);

	}

	public void clickOnElement(WebElement element, String textToBeEntered, long duration) {
		WebElement webElement = waitForElement(element, duration);
		webElement.click();
	}

	public Alert waitForAlert(long duration) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void acceptAlert(long duration) {
		Alert alert = waitForAlert(duration);
		alert.accept();
	}

	public void mouseHoverAndClick(WebElement element, long duration) {
		WebElement webElement = waitForVisibilityOfElement(element, duration);

		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();

	}

	public WebElement waitForVisibilityOfElement(WebElement element, long duration) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return webElement;
	}

	public void javaScriptClick(WebElement element, long duration) {
		WebElement webElement = waitForVisibilityOfElement(element, duration);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webElement);
	}

	public void javaScripttype(WebElement element, long duration, String textToBetyped) {
		WebElement webElement = waitForVisibilityOfElement(element, duration);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + textToBetyped + "'", webElement);
	}

	public String getTextOfElement(WebElement element, long duration) {
		WebElement webElement = waitForVisibilityOfElement(element, duration);
		return webElement.getText();
	}

	public boolean displayStatusOfElement(WebElement element, long duration) {
		try {
			WebElement webElement = waitForVisibilityOfElement(element, duration);
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}
}
