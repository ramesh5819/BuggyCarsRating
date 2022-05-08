package stepDefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageobjects.LandingPage;
import pageobjects.RegistrationPage;
import utils.TestContextSetup;

import java.util.Random;

@RunWith(Cucumber.class)
public class UserRegistrationStepDefinition {
	public WebDriver driver;
	TestContextSetup testContextSetup;
	LandingPage landingpage;
	RegistrationPage registrationpage;

	public UserRegistrationStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingpage = testContextSetup.pageobjectmanager.getLandingPage();
		this.registrationpage = testContextSetup.pageobjectmanager.getRegistartionPage();
	}

	@Given("^user is not registered with application$")
    public void user_is_not_registered_with_application() throws Throwable {
	    //To-Do Make an API call to check if the user is already an existing user
		landingpage.clickRegister();
    }

    @When("^user enters valid username (.+)$")
    public void user_enters_valid_username(String username) throws Throwable {
        Random rand = new Random();
        registrationpage.enterLogin(username+ Integer.toString(rand.nextInt(100000000)));

    }

    @When("^user enters valid firstname (.+)$")
    public void user_enters_valid_firstname(String firstname) throws Throwable {
        registrationpage.enterfirstName(firstname);
    }


    @When("^user enters valid lastname (.+)$")
    public void user_enters_valid_lastname(String lastname) throws Throwable {
        registrationpage.enterlastName(lastname);
    }

    @When("^user enters valid password (.+)$")
    public void user_enters_valid_password(String password) throws Throwable {
        registrationpage.enterPassword(password);
    }

    @When("^user enters valid confirmpassword (.+)$")
    public void user_enters_valid_confirmpassword(String confirmpassword) throws Throwable {
        registrationpage.enterConfirmPassword(confirmpassword);
    }

    @When("^user submit Register$")
    public void user_submit_valid_register() throws Throwable {
        registrationpage.clickRegister();
    }

    @When("^user enters invalid (.+)$")
    public void user_enters_invalid(String username) throws Throwable {
    	System.out.println(username);
    }

    @When("^user submit invalid (.+)$")
    public void user_submit_invalid(String register) throws Throwable {
        System.out.println("register");
    }

    @Then("^user registration should be successful$")
    public void user_registration_should_be_successful() throws Throwable {
        registrationpage.validateRegistrationSuccess();
    }

    @Then("^user registration should be unsuccessful$")
    public void user_registration_should_be_unsuccessful() throws Throwable {
    	System.out.println("Pending");
    }


    @When("user tries to register with the same username")
    public void userTriesToRegisterWithTheSameUsername() {

    }

    @Given("user is already registered with th website")
    public void userIsAlreadyRegisteredWithThWebsite() {
    }

    @Then("user registration should not be successful")
    public void userRegistrationShouldNotBeSuccessful() {

    }

    @And("Validation message displayed as user already registered")
    public void validationMessageDisplayedAsUserAlreadyRegistered() {
    }
}
