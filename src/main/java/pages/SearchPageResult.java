package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageResult {

	WebDriver driver;
	
	public SearchPageResult(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMatchedtext;
	
	public boolean verifyValidProductDisplyed(String productText) {
		return driver.findElement(By.linkText(productText)).isDisplayed();
	}
	
	public String getNoProductMatchedtext() {
		return noProductMatchedtext.getText();
	}
}
