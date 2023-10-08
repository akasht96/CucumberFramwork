package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement  emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath ="//b[text()='Privacy Policy']/parent::a/following-sibling::input[@type='checkbox']")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement newsLetterField;
	
	@FindBy(xpath = "//b[text()='Privacy Policy']/parent::a/following-sibling::input[@value='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarning;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacypolicyWarning;
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement fistNameWarning;
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastnameWarning;
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enteremail(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	public void enterpassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
	}
	
	public void selectPrivayPolicy() {
		privacyPolicyField.click();
	}
	
	public void selectNewLetterOprtion() {
		newsLetterField.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		ContinueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public String getDuplicateEmailWarningText() {
		return duplicateEmailWarning.getText();
	}
	
	public String getprivacypolicyWarningText() {
		return privacypolicyWarning.getText();
	}
	
	public String getfistNameWarningText() {
		return fistNameWarning.getText();
	}
	
	public String getlastnameWarningText() {
		return lastnameWarning.getText();
	}
	
	public String getemailWarningText() {
		return emailWarning.getText();
	}
	
	public String gettelephoneWarningText() {
		return telephoneWarning.getText();
	}
	
	public String getpasswordWarningText() {
		return passwordWarning.getText();
	}
}
