package stepDefinitions;


import org.junit.runner.RunWith;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.WebDriver;
import pageobjects.*;
import utils.TestContextSetup;

import java.util.Random;

@RunWith(Cucumber.class)
public class VotingStepDefinition {
	public WebDriver driver;
	int beforeVoteCount=0;
	TestContextSetup testContextSetup;
	LandingPage landingpage;
	RegistrationPage registrationpage;
	LoginPage loginPage;
	HomePage homePage;
	SelectModelPage selectModelPage;
	VotingPage votingPage;

	public VotingStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingpage = testContextSetup.pageobjectmanager.getLandingPage();
		this.registrationpage = testContextSetup.pageobjectmanager.getRegistartionPage();
		this.loginPage = testContextSetup.pageobjectmanager.getLoginPage();
		this.homePage = testContextSetup.pageobjectmanager.getHomePage();
		this.selectModelPage = testContextSetup.pageobjectmanager.getSelectModelPage();
		this.votingPage = testContextSetup.pageobjectmanager.getVotingPage();
	}

	

	    @Given("^User is registered and logged in$")
	    public void user_is_registered_and_logged_in() throws Throwable {

			Random rand = new Random();
			String _username =  "username"+ Integer.toString(rand.nextInt(100000000));
			String _password = "Password@"+ Integer.toString(rand.nextInt(100000000));
	        landingpage.clickRegister();
			registrationpage.enterLogin(_username);
			registrationpage.enterfirstName("firstname");
			registrationpage.enterlastName("lastname");
			registrationpage.enterPassword(_password);
			registrationpage.enterConfirmPassword(_password);
			registrationpage.clickRegister();
			loginPage.loginAs(_username, _password);
			landingpage.clickOnLogin();
			homePage.clickHomePageLogo();
	    }

	    @When("^he votes for a car$")
	    public void he_votes_for_a_car() throws Throwable {
	        landingpage.clickPopularMake();
			selectModelPage.chooseModel();
			votingPage.enterComment("Nice Car!");
			beforeVoteCount = votingPage.getCurrentVoteCount();
			votingPage.clickVote();

	    }

	    @When("^he opens the car voting page$")
	    public void he_opens_the_car_voting_page() throws Throwable {
	       
	    }

	    @Then("^the vote should be recorded$")
	    public void the_vote_should_be_recorded() throws Throwable {
			votingPage.validateVote();
			assert (votingPage.getCurrentVoteCount()==beforeVoteCount+1);
	    }

	    @Then("^he should not be able to vote again$")
	    public void he_should_not_be_able_to_vote_again() throws Throwable {
	       
	    }

	    @And("^he did not already vote for a car$")
	    public void he_did_not_already_vote_for_a_car() throws Throwable {
	        //Make an API call to chek that he did not vote for a car.
	    }

	    @And("^vote should be displayed in voting history$")
	    public void vote_should_be_displayed_in_voting_history() throws Throwable {
	      votingPage.validateVotingHistory();
	    }

	    @And("^he already placed his vote for a car$")
	    public void he_already_placed_his_vote_for_a_car() throws Throwable {
	       
	    }

}
