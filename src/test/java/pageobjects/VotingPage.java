package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class VotingPage {
	
	public WebDriver driver;
	GenericUtils utils;
	public VotingPage(WebDriver driver) {
		this.driver = driver;
		utils = new GenericUtils(driver);
	}
	
	
	
	
	By comment = By.id("comment");
	By vote = By.xpath("//button[contains(text(),'Vote!')]");
	By voteNote = By.xpath("//div[@class='card-block']/p");
	By voteSuccess = By.xpath(".//p[@class ='card-text']");
	By currentVoteCount = By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[1]/h4/strong");
	By votingHistoryCheck = By.xpath("/html/body/my-app/div/main/my-model/div/div[3]/table/tbody/tr[1]/td[3]");



	public void enterComment(String texttoComment) {
		utils.sendText(comment, texttoComment);
}
	
	public void clickVote() {
		utils.click(vote);
	}
	
	
	private String getVoteNote() {
		return utils.getText(voteNote);
	}


	public void validateVote() {
		utils.waitForElementVisibility(driver.findElement(voteSuccess));
		assert(driver.findElement(voteSuccess).isDisplayed());
	}

	public int getCurrentVoteCount() {
		System.out.println(driver.findElement(currentVoteCount).getText());
		int count = Integer.parseInt(driver.findElement(currentVoteCount).getText());
		return count;
	}

	public void validateVotingHistory() {
		assert (driver.findElement(votingHistoryCheck).getText().equalsIgnoreCase("Nice Car"));
	}
}


