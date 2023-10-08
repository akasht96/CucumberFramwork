package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myaccountDropMenu;
	
	@FindBy(linkText = "Login")
	public WebElement loginlinkText;
	
	@FindBy(linkText = "Register")
	public WebElement registerlinkText;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public LoginPage clickOnLoginoption() {
		loginlinkText.click();
		return new LoginPage(driver);
	}
	
	public void clickOnMyAccountOption() {
		myaccountDropMenu.click();
	}
	
	public RegisterPage clickregisteroption() {
		registerlinkText.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductNameIntoSearchField(String productName) {
		searchBoxField.sendKeys(productName);
	}
	
	public SearchPageResult clickOnSearchButton() {
		searchButton.click();
		return new SearchPageResult(driver);
	}
}
