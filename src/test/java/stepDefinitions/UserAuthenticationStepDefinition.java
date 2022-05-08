package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import utils.TestContextSetup;

@RunWith(Cucumber.class)
public class UserAuthenticationStepDefinition {

    public WebDriver driver;
    TestContextSetup testContextSetup;
    LandingPage landingpage;
    RegistrationPage registrationpage;
    HomePage homePage;
    LoginPage loginPage;

    public UserAuthenticationStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingpage = testContextSetup.pageobjectmanager.getLandingPage();
        this.registrationpage = testContextSetup.pageobjectmanager.getRegistartionPage();
        this.homePage = testContextSetup.pageobjectmanager.getHomePage();
        this.loginPage = testContextSetup.pageobjectmanager.getLoginPage();
    }

    @Given("^user launches the home page$")
    public void user_launches_the_home_page() throws Throwable {
        homePage.launchHomePage();
    }

    @Given("^website is in a logged in state$")
    public void website_is_in_a_logged_in_state() throws Throwable {
       
    }

    @When("^user login with valid credentials$")
    public void user_login_with_valid_credentials() throws Throwable {
        loginPage.loginAs("ramesh.kadali@mailinator.com","Nuttertools.0443");
        landingpage.clickOnLogin();
    }

    @When("^user login with invalid credentials$")
    public void user_login_with_invalid_credentials() throws Throwable {
        
    }

    @When("^user logs out$")
    public void user_logs_out() throws Throwable {
       
    }

    @Then("^Website should be in a logged in state$")
    public void website_should_be_in_a_logged_in_state() throws Throwable {
       loginPage.validateWebsiteloggedinState();
    }

    @Then("^Website should not be in a logged in state$")
    public void website_should_not_be_in_a_logged_in_state() throws Throwable {
      
    }

    @Then("^website should be in a logged out state$")
    public void website_should_be_in_a_logged_out_state() throws Throwable {
       
    }
}
