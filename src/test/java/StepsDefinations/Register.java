package StepsDefinations;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utilities.CommonUtils;

public class Register {

	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	@Given("User navigates to registeration page")
	public void user_navigates_to_registeration_page() {
		driver = DriverFactory.getDriver();
		homePage=new HomePage(driver);
		homePage.clickOnMyAccountOption();
		registerPage=homePage.clickregisteroption();

	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> userDetails = dataTable.asMap();
		registerPage.enterFirstName(userDetails.get("firstName"));
		registerPage.enterLastName(userDetails.get("lastname"));
		registerPage.enteremail(CommonUtils.getEmailwithTimestamp());
		registerPage.enterTelephone(userDetails.get("telephone"));
		registerPage.enterpassword(userDetails.get("password"));
		registerPage.enterConfirmPassword(userDetails.get("password"));
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> userDetails = dataTable.asMap();
		registerPage.enterFirstName(userDetails.get("firstName"));
		registerPage.enterLastName(userDetails.get("lastname"));
		registerPage.enteremail(userDetails.get("email"));
		registerPage.enterTelephone(userDetails.get("telephone"));
		registerPage.enterpassword(userDetails.get("password"));
		registerPage.enterConfirmPassword(userDetails.get("password"));
	}

	@When("user selects privacy policy")
	public void user_selects_privacy_policy() {
		registerPage.selectPrivayPolicy();
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		accountSuccessPage=registerPage.clickOnContinueButton();
	}

	@Then("user account should get an account created successfully")
	public void user_account_should_get_an_account_created_successfully() {

		String accountCreatedtext = accountSuccessPage.getPageHeading();
		Assert.assertTrue("Your Account Has Been Created Text Not Displayed", accountCreatedtext.contains("Your Account Has Been Created!"));
	}

	@When("user selects yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.selectNewLetterOprtion();
	}

	@Then("user should get proper warning message about duplicate email")
	public void user_should_get_proper_warning_message_about_duplicate_email() {
		Assert.assertEquals("E-Mail Address is already registered Warning Not Displayed","Warning: E-Mail Address is already registered!", registerPage.getDuplicateEmailWarningText());
	}

	@Then("user should get proper warning message for every mandatory fields")
	public void user_should_get_proper_warning_message_for_every_mandatory_fields() {
		
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",registerPage.getprivacypolicyWarningText());
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getfistNameWarningText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getlastnameWarningText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getemailWarningText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.gettelephoneWarningText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getpasswordWarningText());
	
	}
	
	public String getEmailwithTimestamp() {
		return "akashthkare"+new Date().toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}

}
