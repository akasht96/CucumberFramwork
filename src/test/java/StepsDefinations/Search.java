package StepsDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPageResult;


public class Search {

	WebDriver driver;
	private HomePage homePage;
	private SearchPageResult searchPageResult;
	@When("users opens the application")
	public void users_opens_the_application() {
	    driver=DriverFactory.getDriver();
	    homePage=new HomePage(driver);
	}

	@When("user enters product name {string} into search field")
	public void user_enters_product_name_into_search_field(String productName) {
	    homePage.enterProductNameIntoSearchField(productName);
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		searchPageResult=homePage.clickOnSearchButton();
	}

	@Then("user should get valid product displayed in search result")
	public void user_should_get_valid_product_displayed_in_search_result() {
		Assert.assertTrue(searchPageResult.verifyValidProductDisplyed("HP LP3065"));
		Assert.assertFalse(true);
	   
	}

	@Then("user should get a message about no product found")
	public void user_should_get_a_message_about_no_product_found() {
		Assert.assertEquals("No product that matches the search criteria Warning Not Displayed ","There is no product that matches the search criteria.", searchPageResult.getNoProductMatchedtext());
		
	}
}
