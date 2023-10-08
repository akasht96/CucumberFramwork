package StepsDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.CommonUtils;

public class Login {

	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		driver=DriverFactory.getDriver();
		homePage=new HomePage(driver);
		homePage.clickOnMyAccountOption();
		loginPage=homePage.clickOnLoginoption();
			   
	}
	
//	@When("^user has enters valid emailaddress (.+) into email field$")
//	public void user_has_enters_valid_emailaddress_into_email_field(String validEmail) {
//		
//		loginPage.enterEmailAddress(validEmail);
//	}
//	
//	@When("^user has enters valid password (.+) into password field$")
//	public void user_has_enters_valid_password_into_password_field(String validPassword) {
//		loginPage.enterpassword(validPassword);
//	}

	@When("user has enters valid emailaddress {string} into email field")
	public void user_has_enters_valid_emailaddress_into_email_field(String validEmail) {
		
		loginPage.enterEmailAddress(validEmail);
	}

	@When("user has enters valid password {string} into password field")
	public void user_has_enters_valid_password_into_password_field(String validPassword) {
		loginPage.enterpassword(validPassword);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		accountPage=loginPage.clickOnLoginButton();
	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() throws InterruptedException {
		//Thread.sleep(3000);
		try {
		//WebElement Edityouraccountinfo = driver.findElement(By.xpath("//li/a[text()='Edit your account information']"));
	    //new WebDriverWait(driver, Duration.ofSeconds(15))
	    //.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Edityouraccountinfo")));
	
		Assert.assertTrue("Edit your account information Option is Displyed!",accountPage.checkeditAccountInfoOptionisVisible());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@When("user has enters invalid emailaddress {string} into email field")
	public void user_has_enters_invalid_emailaddress_into_email_field(String invalidEmail) {
		loginPage.enterEmailAddress(CommonUtils.getEmailwithTimestamp());
	}

	@When("user has enters invalid password {string} into password field")
	public void user_has_enters_invalid_password_into_password_field(String invalidPassword) {
		loginPage.enterpassword(invalidPassword); 
	}

	@Then("user should get proper warning message about given credentials mismatched")
	public void user_should_get_proper_warning_message_about_given_credentials_mismatched() throws InterruptedException {
		Thread.sleep(3000);
	    Assert.assertTrue("User did not got warning message about given credentials mismatched", loginPage.getCredentialsMismatchedWarning().contains("Warning: No match for E-Mail Address and/or Password."));
	}

}
